package academy.mindswap.school.configs;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * the JwtTokenUtil is responsible for performing JWT operations like creation and validation
 * it makes use of the io.jsonwebtoken.Jwts for achieving this
 */
@Component
public class JwtTokenUtil implements Serializable {
    @Serial
    private static final long serialVersionUID = -2550185165626007488L;

    //public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expirationDateInMs}")
    private Long jwtTokenValidity;

    /**
     * for retrieving any information from token we will need the secret key
     */
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);

        return claimsResolver.apply(claims);
    }

    /**
     * retrieve username from jwt token
     */
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    /**
     * retrieve expiration date from jwt token
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    /**
     * check if the token has expired
     */
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);

        return expiration.before(new Date());
    }

    /**
     * while creating the token -
     * 1. Define claims of the token, like Issuer, Expiration, Subject, and the ID
     * 2. Sign the JWT using the HS512 algorithm and secret key
     * 3. According to JWS Compact Serialization
     * (https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1) compaction of the JWT to a
     * URL-safe string
     */
    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                //.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .setExpiration(new Date(System.currentTimeMillis() + jwtTokenValidity))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * generate token for user
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();

        claims.put("roles", userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList());

        return doGenerateToken(claims, userDetails.getUsername());
    }

    /**
     * validate token
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);

        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
