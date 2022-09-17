package academy.mindswap.school.security;

import academy.mindswap.school.utils.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static academy.mindswap.school.exceptions.authentication.JwtAuthenticationExceptionMessages.CANNOT_SET_SECURITY_CONTEXT;
import static academy.mindswap.school.exceptions.authentication.JwtAuthenticationExceptionMessages.UNAUTHORIZED;

/**
 * the JwtRequestFilter extends the Spring Web Filter OncePerRequestFilter class
 * for any incoming request this Filter class gets executed
 * it checks if the request has a valid JWT token
 * if it has a valid JWT Token then it sets the Authentication in the context, to specify that the current user is
 * authenticated
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
    private final JwtUtil jwtUtil;

    @Value("${jwt.allowForRefreshTokenExpirationDateInMs}")
    private int allowForRefreshTokenExpirationDateInMs;

    @Autowired
    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    private String extractJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }

        return null;
    }

    private void allowForRefreshToken(ExpiredJwtException exception, HttpServletRequest request) {
        // create a UsernamePasswordAuthenticationToken with null values
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(null, null, null);

        // after setting the Authentication in the context, we specify that the current user is authenticated
        // so it passes the Spring Security Configurations successfully
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        // set the claims so that in controller we will be using it to create new JWT
        request.setAttribute("claims", exception.getClaims());
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        // JWT Token is in the form "Bearer token"
        // Remove Bearer word and get only the Token
        String jwtToken = extractJwtFromRequest(request);

        try {
            // if token is valid configure Spring Security to manually set authentication
            if (StringUtils.hasText(jwtToken) && jwtUtil.validateToken(jwtToken)) {
                UserDetails userDetails = new User(jwtUtil.getUsernameFromToken(jwtToken), "",
                        jwtUtil.getRolesFromToken(jwtToken));

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null,
                                userDetails.getAuthorities());

                // after setting the Authentication in the context, we specify that the current user is authenticated
                // so it passes the Spring Security Configurations successfully
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            } else {
                LOGGER.error(CANNOT_SET_SECURITY_CONTEXT);
            }
        } catch (ExpiredJwtException exception) {
            String isRefreshToken = request.getHeader("isRefreshToken");

            String requestURL = request.getRequestURL().toString();

            // allow for Refresh Token creation if following conditions are true
            if (isRefreshToken != null && isRefreshToken.equals("true") && requestURL.contains("refreshtoken") &&
                    !exception.getClaims().getExpiration().before(new Date(new Date().getTime() -
                            allowForRefreshTokenExpirationDateInMs))) {
                allowForRefreshToken(exception, request);
            } else {
                request.setAttribute("exception", exception);

                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, UNAUTHORIZED);

                return;
            }
        } catch (
                BadCredentialsException exception) {
            request.setAttribute("exception", exception);
        } catch (
                Exception exception) {
            LOGGER.error(exception.toString());
        }

        chain.doFilter(request, response);
    }
}
