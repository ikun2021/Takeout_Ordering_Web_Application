package com.zk.controller;

import com.zk.entity.User;
import com.zk.entity.UserLay;
import com.zk.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/myuser")
public class MyUserHandler {
    @Autowired
    private UserFeign userFeign;

    @GetMapping("/redirect/{url}")
    public String redirect(@PathVariable("url") String url){
        return url;
    }

    //通过postman传json数据时需要给参数加上@requestbody注解
    @PostMapping("/save")
    public String save(User user){
        user.setRegisterdate(new Date());
        userFeign.save(user);
        int i=0;
        return "redirect:/myuser/redirect/user_manage";
    }


    //通过html a href发出的请求是get请求
    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        userFeign.deleteById(id);
        return "redirect:/myuser/redirect/user_manage";
    }

    @GetMapping("/count")
    public int count(){
        return userFeign.count();
    }


    //需要返数据给前端页面，否被会被当做视图解析
    @GetMapping("/findAll")
    @ResponseBody
    public UserLay findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index = (page-1)*limit;
        return userFeign.findAll(index,limit);
    }

}
