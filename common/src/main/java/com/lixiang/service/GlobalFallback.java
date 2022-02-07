package com.lixiang.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/7 17:18
 */
public class GlobalFallback {
    public static String globalFallbackMethod(){
        return "全局连接超时调用~~~~~~~`(*>﹏<*)′";
    }
}
