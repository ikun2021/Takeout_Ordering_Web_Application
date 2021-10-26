package com.zk.controller;


import com.zk.entity.Menu;
import com.zk.entity.Order;
import com.zk.entity.OrderLay;
import com.zk.entity.User;
import com.zk.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/myorder")
public class MyOrderHandler {
    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/save/{mid}")
    public String save(@PathVariable("mid") Integer mid, HttpSession session){
        User user = (User)session.getAttribute("user");
        Order order = new Order();
        order.setUser(user);
        Menu menu = new Menu();
        menu.setId(mid);
        order.setMenu(menu);
        order.setState(0);
        orderFeign.save(order);
        return "order";
    }

    @GetMapping("/findAllByUid")
    @ResponseBody
    public OrderLay findAllByUid(@RequestParam("page") int page, @RequestParam("limit") int limit,HttpSession session){
        User user = (User) session.getAttribute("user");
        int index = (page-1)*limit;
        return orderFeign.findAllByUid(index, limit, user.getId());
    }

    @GetMapping("/findAllByState")
    @ResponseBody
    public OrderLay findAllByState(@RequestParam("page") int page,@RequestParam("limit") int limit){
        int index= (page-1)*limit;
        return orderFeign.findAllByState(index,limit);
    }

    @GetMapping("/updateState/{id}")
    public String updateState(@PathVariable("id") int id){
        orderFeign.updateState(id);
        return "redirect:/mymenu/redirect/order_handler";
    }
}
