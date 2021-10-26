package com.zk.controller;


import com.zk.entity.Menu;
import com.zk.entity.MenuLay;
import com.zk.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;


@Controller
@RequestMapping("/mymenu")
public class MyMenuHandler {
    @Autowired
    private MenuFeign menuFeign;

//    @Value("${server.port}")
//    private String port;
//
//    @GetMapping("/index")
//    public String index(){
//        return this.port;
//    }

    @GetMapping("/findAll")
    @ResponseBody
    public MenuLay findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index = (page-1)*limit;
        return menuFeign.findAll(index,limit);
    }
    @GetMapping("/redirect/{url}")
    public String redirect(@PathVariable("url") String url){
        return url;
    }

    //通过a href发出的请求，是get请求
    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        menuFeign.deleteById(id);
        return "redirect:/mymenu/redirect/menu_manage";
    }

    //需要展示出来，不返回直接的数据
    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu_update");
        modelAndView.addObject("menu",menuFeign.findById(id));
        modelAndView.addObject("list",menuFeign.findTypes());
        return modelAndView;
    }
    //结合layui展示分类
    @GetMapping("/findTypes")
    public ModelAndView findTypes(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu_add");
        modelAndView.addObject("list",menuFeign.findTypes());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Menu menu){
        menuFeign.save(menu);
        return "redirect:/mymenu/redirect/menu_manage";
    }

    //form发的post请求
    @PostMapping("/update")
    public String update(Menu menu){
        menuFeign.update(menu);
        return "redirect:/mymenu/redirect/menu_manage";

    }



}
