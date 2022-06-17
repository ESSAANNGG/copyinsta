package com.gram.copyinsta.service;

import com.gram.copyinsta.entity.Member;
import com.gram.copyinsta.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        return
                Optional.ofNullable(memberRepository.findByUserId(userId))
                        .filter(m -> m!=null)
                        .map( m -> new SecurityMember((Member) m)).get();
    }
}
