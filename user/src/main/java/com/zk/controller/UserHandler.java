package com.zk.controller;

import com.zk.entity.User;
import com.zk.entity.UserLay;
import com.zk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Integer id){
        return userRepository.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
        userRepository.save(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }

    @GetMapping("/count")
    public int count(){
        return userRepository.count();
    }

    @GetMapping("/findAll/{index}/{limit}")
    public UserLay findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
        return new UserLay(0,"",userRepository.count(),userRepository.findAll(index,limit));
    }






}
