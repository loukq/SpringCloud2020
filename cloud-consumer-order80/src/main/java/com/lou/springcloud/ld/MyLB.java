package com.lou.springcloud.ld;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.Currency;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalancer{

    private AtomicInteger atomicInteger;

    public MyLB() {
        this.atomicInteger = new AtomicInteger(0);
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int count=serviceInstances.size();
//        根据服务的个数取模
        int index=getAndIncrease()%count;
        return serviceInstances.get(index);
    }


//    定义自旋锁和CAS
    public final int getAndIncrease(){
        int current;
        int next;
        for (;;){
            current=atomicInteger.get();
            next=current>=2147483647?0:current+1;
            if (atomicInteger.compareAndSet(current,next)){
                System.out.println("next: "+next);
                return next;
            }
        }

    }

}
