package com.zk.repository;

import com.zk.entity.Admin;
import com.zk.entity.User;

public interface AdminRepository {
    Admin login(String username,String password);
}
