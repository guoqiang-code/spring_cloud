package com.lixiang.entity;

import lombok.Data;

import java.io.Serializable;


/*
@author GuoQiang
@create 2022-01-16 15:27
*/


@Data
public class Payment implements Serializable {
    private Long id;

    private String serial;
}