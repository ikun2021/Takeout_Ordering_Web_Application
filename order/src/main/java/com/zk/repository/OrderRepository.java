package com.zk.repository;

import com.zk.entity.Order;

import java.util.Collection;

public interface OrderRepository {
    public Collection<Order> findAllByUid(int index, int limit,int uid);
    public void save(Order order);
    public int countByUid(int uid);
    public Collection<Order> findAllByState(int index, int limit,int state);
    public void updateState(int id);
    public int countByState(int state);
}
