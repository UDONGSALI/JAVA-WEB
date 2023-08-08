package com.springboot.security.service.impl;

import com.springboot.security.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자를 자동 생성
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    private final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("[loadUserByUsername] loadUserByUsername 수행, username : {}", username);
        return userRepository.getByUid(username);
    }

}
