package com.gram.copyinsta.service;

import com.gram.copyinsta.dto.UserDto;
import com.gram.copyinsta.entity.Role;
import com.gram.copyinsta.entity.User;
import com.gram.copyinsta.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Optional<User> userWrapper = userRepository.findUserByUserId(userId);
        User userEntity = userWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if(("admin@example.com").equals(userId)){
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        }

        return new org.springframework.security.core.userdetails.User(userEntity.getUserId(),userEntity.getPw(),authorities);
    }
}
