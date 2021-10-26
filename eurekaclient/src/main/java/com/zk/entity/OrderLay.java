package com.zk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLay {
    private int code;
    private String msg;
    private int count;
    private Collection<Order> data;

}
