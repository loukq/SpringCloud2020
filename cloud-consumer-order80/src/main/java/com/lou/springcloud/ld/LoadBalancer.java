package com.lou.springcloud.ld;

import org.springframework.cloud.client.ServiceInstance;
import java.util.List;

//自定义的负载均衡接口
public interface LoadBalancer {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
