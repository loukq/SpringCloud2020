package com.lou.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRouteConfig {

    /**
     * 配置了一个id为route-name的路由规则
     * 当访问地址 http://localhost:9527/guonei时会自动转发到地址： http://news.baidu.com/guonei
     * @param
     * @return
     */
    @Bean
    public RouteLocator getRouteLoator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_to_baidunew_guoji",r->r.path("/zgh").uri("http://zgh.com/"));
        routes.route("path_to_baidunew_guonei",r->r.path("/media-center").uri("http://zgh.com/media-center/"));
        return routes.build();
    }

}
