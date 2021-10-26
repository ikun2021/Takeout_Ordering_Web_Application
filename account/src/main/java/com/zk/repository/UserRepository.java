package com.zk.repository;

import com.zk.entity.User;

public interface UserRepository {
    User login(String username,String password);
}
