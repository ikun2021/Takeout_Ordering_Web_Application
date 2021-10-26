package com.zk.feign;
import com.zk.entity.User;
import com.zk.entity.UserLay;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value="user")
public interface UserFeign {

    @GetMapping("/user/findById/{id}")
    public User findById(@PathVariable("id") Integer id);

    @PostMapping("/user/save")
    public void save(@RequestBody User user);

    @DeleteMapping("/user/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id);

    @GetMapping("/user/count")
    public int count();

    @GetMapping("/user/findAll/{index}/{limit}")
    public UserLay findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);
}
