package com.gram.copyinsta.controller;

import com.gram.copyinsta.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;

    @GetMapping("/")
    public String index(){
        return "/index";
    }

    @GetMapping("/user/signup")
    public String dispSignup(){
        return "/signup";
    }
}
