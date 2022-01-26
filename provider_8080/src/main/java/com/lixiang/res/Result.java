package com.lixiang.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
@author GuoQiang
@create 2022-01-16 16:09
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public Result(Integer code, String msg) {
        this.code = code;
        this.message = msg;
        this.data=null;
    }


    public static <T> Result<T> success(T data){
        return new Result<>(0,"成功",data);
    }
    public static <T> Result<T> success(){
        return new Result<>(0,"成功");
    }
    public static <T> Result<T> fail(){
        return new Result<>(10001,"失败");
    }

}
