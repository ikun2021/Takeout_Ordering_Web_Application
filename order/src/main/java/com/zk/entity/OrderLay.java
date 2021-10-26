package com.zk.entity;

import lombok.Data;

import java.util.Collection;

@Data
public class OrderLay {
    private int code;
    private String msg;
    private int count;
    private Collection<Order> data;

}
