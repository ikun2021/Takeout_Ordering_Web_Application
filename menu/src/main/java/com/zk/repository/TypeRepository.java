package com.zk.repository;

import com.zk.entity.Type;
import org.springframework.stereotype.Repository;

import java.util.Collection;


public interface TypeRepository {
    public Type findById(Integer id);
    public Collection<Type> findAll();

}
