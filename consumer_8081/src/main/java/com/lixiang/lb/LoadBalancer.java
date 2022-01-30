package com.lixiang.lb;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/1/30 17:22
 */

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 手动实现负载均衡
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
