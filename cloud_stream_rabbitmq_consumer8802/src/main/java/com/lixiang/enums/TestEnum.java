package com.lixiang.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/17 16:11
 */
@Getter
public enum TestEnum {
    t1(1,"t11"),
    t2(2,"t22"),
    t3(3,"t33"),
    ;

    Integer code;
    String name;
    TestEnum(Integer code,String name){
        this.code=code;
        this.name=name;
    }
}
