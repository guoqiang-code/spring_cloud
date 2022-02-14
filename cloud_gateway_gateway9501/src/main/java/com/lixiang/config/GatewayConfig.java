package com.lixiang.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @date 2022/2/14 10:58
 */
@Component
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_guonei", r -> r.path("/guonei").uri("http://news.baidu.com")).build();
        return routes.build();
    }
}
