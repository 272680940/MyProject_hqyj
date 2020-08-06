package com.hqyj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


/**
 * author  Jayoung
 * createDate  2020/7/27 0027 11:27
 * version 1.0
 */
@Controller
@RequestMapping("tc")
public class TestController {

    //测试shiro
    @RequestMapping("firstShiro.do")
    public String firsShiro(HttpServletRequest req){
        req.getSession().setAttribute("user_id",1);
        req.getSession().setAttribute("customer_id",1);

        return "index";
    }
}
