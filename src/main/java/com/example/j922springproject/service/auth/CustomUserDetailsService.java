package com.example.j922springproject.service.auth;

import com.example.j922springproject.dao.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("ActionLog.loadUserByUsername.start");

        var userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    log.error("ActionLog.loadUserByUsername.error user not found");
                    throw new RuntimeException("USER_NOT_FOUND");
                });

        log.info("ActionLog.loadUserByUsername.end");
        return new CustomUserDetails(userEntity);
    }
}
