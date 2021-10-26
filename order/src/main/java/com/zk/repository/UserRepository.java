package com.zk.repository;

import com.zk.entity.User;

import java.util.Collection;

public interface UserRepository {
    public User findById(Integer id);
    public void save(User user);
    public void deleteById(Integer id);
    public int count();
    public Collection<User> findAll(int index , int limit);
}
