package com.zk.controller;


import aj.org.objectweb.asm.TypeReference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zk.entity.Admin;
import com.zk.entity.User;
import com.zk.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;


//需要跳转到页面，提供数据展示 所以使用controller
@Controller
@RequestMapping("/myaccount")
public class MyAccountHandler {
    @Autowired
    private AccountFeign accountFeign;

    //form表单请求
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        @RequestParam("type") String type, HttpSession session){
        LinkedHashMap<String,Object> hashMap = accountFeign.login(username, password, type);
        String result = null;
        if(hashMap==null){
            result= "login";
        }else{
            switch(type){
                case"user":
                    User user = JSON.parseObject(JSON.toJSONString(hashMap), User.class);
                    session.setAttribute("user",user);
                    result="index";  //是转发形式，不能用重定向，redirect 相当于直接访问页面，没有经过后台，所以没有session，没有视图数据。
                    break;
                case"admin":
                    Admin admin = JSON.parseObject(JSON.toJSONString(hashMap),Admin.class);
                    session.setAttribute("admin",admin);
                    result="main";
                    break;
            }
        }
        return  result;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.html";
    }


}
