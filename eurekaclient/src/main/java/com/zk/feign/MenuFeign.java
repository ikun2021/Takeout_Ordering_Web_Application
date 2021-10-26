package com.zk.feign;


import com.zk.entity.Menu;
import com.zk.entity.MenuLay;
import com.zk.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@FeignClient(value = "menu")
public interface MenuFeign {
    @GetMapping("/menu/findAll/{index}/{limit}")
    MenuLay findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @DeleteMapping("/menu/deleteById/{id}")
    void deleteById(@PathVariable("id") Integer id);

    @GetMapping("/menu/findTypes")
    Collection<Type> findTypes();

    @PostMapping("/menu/save")
    void save(Menu menu);

    @PutMapping("/menu/update")
    void update(Menu menu);


    @GetMapping("/menu/findById/{id}")
    Menu findById(@PathVariable("id") Integer id);
}

