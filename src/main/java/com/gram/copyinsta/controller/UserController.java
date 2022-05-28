package com.gram.copyinsta.controller;

import com.gram.copyinsta.dto.UserDto;
import com.gram.copyinsta.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "/index";
    }
    //쓰레기코드 추가

    @GetMapping("/user/signup")
    public String dispSignup(){
        return "/signup";
    }

    @PostMapping("/user/signup")
    public String execSignup(UserDto userDto){
        userService.joinUser(userDto);
        return "redirect:/user/login";
    }

    @GetMapping("/user/login")
    public String login(){
        return "/login";
    }

    @GetMapping("/user/login/result")
    public String loginResult() {
        return "/loginSuccess";
    }

    @GetMapping("/user/logout/result")
    public String logout() {
        return "/logout";
    }

    @GetMapping("/user/denied")
    public String denied() {
        return "/denied";
    }

    @GetMapping("/user/info")
    public String UserInfo() {
        return "/userinfo";
    }

    @GetMapping("/admin")
    public String Admin() {
        return "/admin";
    }
}
