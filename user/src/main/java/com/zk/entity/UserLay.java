package com.zk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLay {
    private int code;
    private String mgs;
    private int count;
    private Collection<User> data;
}
