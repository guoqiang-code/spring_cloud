package com.lixiang.res;

import lombok.Data;

/*
@author GuoQiang
@create 2022-01-16 16:09
*/
@Data
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    private Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data=null;
    }

    private Result() {
    }

    private Result(Integer code, String msg,T data) {
        this.code = code;
        this.msg = msg;
        this.data=data;
    }

    public static <T> Result<T> success(T data){
        return new Result<>(0,"成功",data);
    }
    public static <T> Result<T> fail(){
        return new Result<>(10001,"失败");
    }

}
