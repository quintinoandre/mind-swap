package academy.mindswap.school.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
public class RequestHandler {
    private final academy.mindswap.school.utils.JwtUtil jwtUtil;

    @Autowired
    public RequestHandler(academy.mindswap.school.utils.JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public String getTeacherId(HttpServletRequest request) {
        final String BEARER_PREFIX = "Bearer ";

        return jwtUtil.getTeacherIdFromToken(request.getHeader(AUTHORIZATION).substring(BEARER_PREFIX.length()));
    }
}
