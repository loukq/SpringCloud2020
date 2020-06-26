package com.lou.springcloud.service;

import com.lou.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//通过远程进行调用
@FeignClient(value = "seata-storage-service")
public interface StorageService {
//    productId为扣减商品的id，count为扣减的数量
    @GetMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId")Long productId,@RequestParam("count")Integer count);
}
