package com.mk.onevone.controller;

import com.alibaba.fastjson.JSONObject;
import com.mk.onevone.dto.ResultDTO;
import com.mk.onevone.entity.User;
import com.mk.onevone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getLoginInfo")
    public Object getLoginInfo(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",request.getSession().getAttribute("id"));
        jsonObject.put("username",request.getSession().getAttribute("username"));
        return jsonObject;
    }
    @RequestMapping(value = "/checkLogin")
    public String checkLogin(){
        return null;
    }
    @RequestMapping(value = "/login")
    public Object login(User user){
        return userService.getLogin(user);
    }
    @RequestMapping(value = "/getMessageCode")
    public Object getMessageCode(String phone){
        if(phone.length() != 11){
            return new ResultDTO<>(-1);
        }
        return userService.getMessageCode(phone);
    }
    @RequestMapping(value = "/getMessageLogin")
    public Object getMessageLogin(String phone, String code){

        return userService.getCodeLogin(phone, code);
    }
}
