package com.gram.copyinsta.controller;

import com.gram.copyinsta.entity.Member;
import com.gram.copyinsta.entity.MemberRole;
import com.gram.copyinsta.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/signUp")
    public String signUp1(){
        return "/member/signUp";
    }

    @RequestMapping(value = "",method =  RequestMethod.POST)
    public String signUp(Member member){
        MemberRole memberRole = new MemberRole();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        member.setPw(bCryptPasswordEncoder.encode(member.getPw()));
        memberRole.setRoleName("BASIC");
        member.setMemberRoles(Arrays.asList(memberRole));
        memberRepository.save(member);
        return "redirect:/";
    }
}
