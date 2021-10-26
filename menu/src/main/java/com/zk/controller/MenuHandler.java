package com.zk.controller;


import com.zk.entity.Menu;
import com.zk.entity.MenuLay;
import com.zk.entity.Type;
import com.zk.repository.MenuRepository;
import com.zk.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/menu")
public class MenuHandler {
    @Value("${server.port}")
    private String port;

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private TypeRepository typeRepository;

    @GetMapping("/index")
    public String index(){
        return this.port;
    }

    @GetMapping("findAll/{index}/{limit}")
    public MenuLay findAll(@PathVariable("index") int index ,@PathVariable("limit") int limit){
        return new MenuLay(0,"",menuRepository.count(),menuRepository.findAll(index,limit));
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        menuRepository.deleteById(id);
    }

    @GetMapping("/findTypes")
    public Collection<Type> findTypes(){
        return typeRepository.findAll();
    }

    //requestbody 将json数据转为menu
    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuRepository.save(menu);
    }


    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") Integer id){

        return menuRepository.findById(id);
    }

    //requestbody 将json数据转为menu
    @PutMapping("/update")
    public void update(@RequestBody Menu menu){
        menuRepository.update(menu);

    }
}
