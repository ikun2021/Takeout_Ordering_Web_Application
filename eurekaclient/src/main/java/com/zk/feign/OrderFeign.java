package com.zk.feign;

import com.zk.entity.Order;
import com.zk.entity.OrderLay;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value="order")
public interface OrderFeign {

    @PostMapping("/order/save")
    public void save(@RequestBody Order order);


    @GetMapping("/order/findByUid/{index}/{limit}/{uid}")
    public OrderLay findAllByUid(@PathVariable("index") int index, @PathVariable("limit") int limit, @PathVariable("uid") int uid);

    @GetMapping("/order/findAllByState/{index}/{limit}")
    public OrderLay findAllByState(@PathVariable("index") int index,@PathVariable("limit") int limit);

    @PutMapping("/order/updateState/{id}")
    public void updateState(@PathVariable("id") int id);
}
