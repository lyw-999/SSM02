package com.xiexin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 改控制类 是为了查找jsp或者是 带参数访问jsp
@Controller
@RequestMapping("/pages")
public class PagesController {

    @RequestMapping("/reg")
    public String reg(){
        System.out.println("请求进入注册 有人来了");
        return "reg";// return 一个界面
    }
    @RequestMapping("/regForm")
    public String regForm(){
        return  "regForm";
    }
    @RequestMapping("/login")
    public String login(){
        return  "login";
    }

    @RequestMapping("/ajaxCommit")
    public String ajaxCommit(){
        return  "ajaxCommit";
    }

    @RequestMapping("/loginForm")
    public String loginForm(){
        return  "loginForm";
    }


    @RequestMapping("/farm")
    public String farm(){
        return  "farm";
    }
    @RequestMapping("/home")
    public String home(){
        return  "home";
    }
}
