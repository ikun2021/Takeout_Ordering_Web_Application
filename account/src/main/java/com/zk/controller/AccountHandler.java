package com.zk.controller;


import com.zk.entity.Admin;
import com.zk.entity.User;
import com.zk.repository.AdminRepository;
import com.zk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//多态处理admin和user
@RestController
@RequestMapping("/account")
public class AccountHandler {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;


    @GetMapping("/login/{username}/{password}/{type}")
    public Object login(@PathVariable("username") String username,@PathVariable("password") String password,@PathVariable("type") String type){
        Object object = null;
        switch (type){
            case "admin":
                object =adminRepository.login(username,password);
                break;
            case "user":
                object =userRepository.login(username,password);
                break;
        }
        return object;
    }

}
