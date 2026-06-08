package com.website.login.Service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.website.login.Entity.UserEntity;
import com.website.login.Repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserEntity> user = repository.findByUsername(username);
        if (user.isPresent()) {
            var userobj = user.get();

            return User.builder()
                    .username(userobj.getUsername())
                    .password(userobj.getPassword())
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
