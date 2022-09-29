package academy.mindswap.school.services;

import academy.mindswap.school.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * JWTUserDetailsService implements the Spring Security UserDetailsService interface
 * it overrides the loadUserByUsername for fetching user details from the database using the username
 * the Spring Security Authentication Manager calls this method for getting the user details from the database when
 * authenticating the user details provided by the user
 * also the password for a user is stored in encrypted format using BCrypt
 */
@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {
    private final TeacherService teacherService;

    @Autowired
    public CustomUserDetailsServiceImpl(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        final String ROLE_PREFIX = "ROLE_";

        Teacher teacher = teacherService.findByEmailWithRoles(email);

        return new User(teacher.getEmail(), teacher.getPassword(), new ArrayList<>(teacher.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(ROLE_PREFIX.concat(role.getType()))).toList()));
    }
}
