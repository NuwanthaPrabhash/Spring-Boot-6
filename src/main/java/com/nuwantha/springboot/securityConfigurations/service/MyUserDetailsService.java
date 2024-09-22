package com.nuwantha.springboot.securityConfigurations.service;

import com.nuwantha.springboot.securityConfigurations.model.MyUserDetails;
import com.nuwantha.springboot.securityConfigurations.model.Users;
import com.nuwantha.springboot.securityConfigurations.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = this.userRepository.findByUsername(username);
        if (user == null) {
            System.out.println("UserNot found");
            throw new UsernameNotFoundException("User Not Found");
        }
        return new MyUserDetails(user);
    }
}
