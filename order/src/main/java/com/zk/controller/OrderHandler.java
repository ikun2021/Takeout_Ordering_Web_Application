package com.zk.controller;


import com.zk.entity.Order;
import com.zk.entity.OrderLay;
import com.zk.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("/order")
public class OrderHandler {
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/save")
    public void save(@RequestBody Order order){
        order.setDate(new Date());
        orderRepository.save(order);
    }


    @GetMapping("/findAllByUid/{index}/{limit}{uid}")
    public OrderLay findAllByUid(@PathVariable("index") int index, @PathVariable("limit") int limit, @PathVariable("uid") int uid){
        OrderLay orderLay = new OrderLay();
        orderLay.setCode(0);
        orderLay.setMsg("");
        orderLay.setCount(orderRepository.countByUid(uid));
        orderLay.setData(orderRepository.findAllByUid(index,limit,uid));
        return orderLay;
    }

    @GetMapping("/countByUid/{uid}")
    public int countByUid(@PathVariable("uid") int uid){
        return orderRepository.countByUid(uid);
    }

    @GetMapping("/findAllByState/{index}/{limit}")
    public OrderLay findAllByState(@PathVariable("index") int index,@PathVariable("limit") int limit){
        OrderLay orderLay = new OrderLay();
        orderLay.setCode(0);
        orderLay.setMsg("");
        orderLay.setCount(orderRepository.countByState(0));
        orderLay.setData(orderRepository.findAllByState(index,limit,0));
        return orderLay;
    }


    @PutMapping("/updateState/{id}")
    public void updateState(@PathVariable("id") int id){
        orderRepository.updateState(id);
    }






}
