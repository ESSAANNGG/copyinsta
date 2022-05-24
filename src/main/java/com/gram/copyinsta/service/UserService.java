package com.gram.copyinsta.service;

import com.gram.copyinsta.dto.UserDto;
import com.gram.copyinsta.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;

public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    @Transactional
    public Long joinUser(UserDto userDto){
        //비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userDto.setPw(passwordEncoder.encode(userDto.getPw()));

        return userRepository.save(userDto.toEntity()).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
