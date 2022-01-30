package com.lixiang.lb.impl;

import com.lixiang.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/1/30 17:24
 */

/**
 * 实现负载均衡
 */
@Component
public class LoadBalancerImpl implements LoadBalancer {

    private AtomicInteger atomicInteger=new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current=atomicInteger.get();
            next=current>=2147483647?0:current+1;

            /**自旋锁
             * compareAndSet(expectedValue, newValue) : 如果当前值(current value)等于期待的值(expectedValue),
             * 则原子地更新指定值为新值(newValue), 如果更新成功，返回true, 否则返回false,
             * 换句话可以这样说: 将原子变量设置为新的值,
             * 但是如果从我上次看到的这个变量之后到现在被其他线程修改了(和我期望看到的值不符), 那么更新失败
             */
        }while (!atomicInteger.compareAndSet(current,next));
        System.out.println("访问次数next:  "+next);
        return next;
    }


    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
