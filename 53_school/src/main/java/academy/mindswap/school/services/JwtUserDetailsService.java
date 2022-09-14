package academy.mindswap.school.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface JwtUserDetailsService extends UserDetailsService {
    @Override
    UserDetails loadUserByUsername(String email);
}
