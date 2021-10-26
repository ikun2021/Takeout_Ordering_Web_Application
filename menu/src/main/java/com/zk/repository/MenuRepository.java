package com.zk.repository;

import com.zk.entity.Menu;
import org.springframework.stereotype.Repository;


import java.util.Collection;


public interface MenuRepository {
    //分页式查询
    public Collection<Menu> findAll(int index ,int limit);
    public Menu findById(Integer id);
    public void save(Menu menu);
    public void update(Menu menu);
    public void deleteById(Integer id);
    public int count();


}
