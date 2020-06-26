package com.lou.springcloud.controller;

import com.lou.springcloud.domain.CommonResult;
import com.lou.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;

    @GetMapping("/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200, "库存扣减成功");
    }
}
