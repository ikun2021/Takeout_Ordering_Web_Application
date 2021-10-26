package com.zk.feign;

import com.zk.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.LinkedHashMap;

@FeignClient(value="account")
public interface AccountFeign {
    @GetMapping("/account/login/{username}/{password}/{type}")
    public LinkedHashMap<String,Object> login(@PathVariable("username") String username, @PathVariable("password") String password,
                               @PathVariable("type") String type);

}
