package com.chj.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/1/30 15:11
 */

/**
 * 改变Ribbon负载均衡规则的类，官方明确说不可以放在@ComponentScan可以扫描到的地方
 */
@Configuration
public class NetflixRule {

    @Bean
    public IRule myRule() {
        //定义为随机访问
        return new RandomRule();
    }

}
