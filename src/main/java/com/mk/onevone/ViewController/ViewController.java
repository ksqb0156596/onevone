package com.mk.onevone.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 01436296 on 2017/10/12.
 */
@Controller
public class ViewController {
    @RequestMapping(value = "/group")
    public String group(){
        return "/group";
    }
    @RequestMapping(value = "/personal")
    public String personal(){
        return "/personal";
    }
    @RequestMapping(value = "/recommend")
    public String recommend(){
        return "/recommend";
    }
    @RequestMapping(value = "/login")
    public String login(){
        return "/login";
    }
}
