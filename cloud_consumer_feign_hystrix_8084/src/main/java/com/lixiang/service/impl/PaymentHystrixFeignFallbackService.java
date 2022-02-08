package com.lixiang.service.impl;

import com.lixiang.service.PaymentHystrixFeignService;
import org.springframework.stereotype.Component;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/7 18:26
 */
@Component
public class PaymentHystrixFeignFallbackService implements PaymentHystrixFeignService {
    @Override
    public String providerInfo(Integer id) {
        return "PaymentHystrixFeignFallbackService fallback -------providerInfo    /(ㄒoㄒ)/~~";
    }

    @Override
    public String providerInfoTimeout(Integer id) {
        return "PaymentHystrixFeignFallbackService fallback -------providerInfoTimeout    /(ㄒoㄒ)/~~";
    }

    @Override
    public String providerInfoCircuitBreaker(Integer id) {
        return "PaymentHystrixFeignFallbackService fallback -------providerInfoCircuitBreaker    /(ㄒoㄒ)/~~";
    }
}
