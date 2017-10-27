package com.mk.onevone.controller;

import com.mk.onevone.entity.User;
import com.mk.onevone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/checkLogin")
    public String checkLogin(){
        return null;
    }
    @RequestMapping(value = "/login")
    public Object login(User user){

        return userService.getLogin(user);
    }
}
