package demo.authoriztion.server.security;

import demo.authoriztion.server.persistence.UserRepository;
import demo.authoriztion.server.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetailsServiceImpl() {
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            User user = userRepository.findByEmail(email);
            if(user == null) {
                throw new UsernameNotFoundException("No user found with email " + email);
            }
            return new  org.springframework.security.core.userdetails.User(
                    user.getEmail(), user.getPassword(),
                    true, true, true, true,
                    Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
