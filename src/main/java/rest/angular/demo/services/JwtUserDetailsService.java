package rest.angular.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rest.angular.demo.data.UserCredentials;
import rest.angular.demo.repo.UsersCredentials;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    UsersCredentials usersCredentials;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentials user = usersCredentials.findFirstByUsername(username);
        if (user != null) {
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getRole()));
            return new User(user.getUsername(), user.getPassword(),
                    authorities);
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

}