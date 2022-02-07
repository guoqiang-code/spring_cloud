package com.lixiang.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/7 13:54
 */

public interface PaymentService {
    public String providerInfo(Integer id);


    public String providerInfoTimeout(Integer id);
}
