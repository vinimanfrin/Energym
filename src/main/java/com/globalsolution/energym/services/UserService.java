package com.globalsolution.energym.services;

import com.globalsolution.energym.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.globalsolution.energym.domain.entities.User> user = repository.findByUsername(username);
        if (user.isPresent()) {
            var userObj = user.get();
            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .build();
        }else{
            throw new UsernameNotFoundException(username);
        }
    }

    public com.globalsolution.energym.domain.entities.User authenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return findByUsername(authentication.getName());
    }

    public com.globalsolution.energym.domain.entities.User findByUsername(String username){
        return repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User não encontrado para o username: " + username));
    }
}
