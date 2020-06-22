package com.lou.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lou.springcloud.handle.CustomerHandler;
import com.lou.springcloud.service.FilterService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {

    @Autowired
    private FilterService filterService;

    @GetMapping("/testAA")
    private String testAA() throws InterruptedException {
//        Thread.sleep(1000);
        return filterService.getOrder();
    }

    @GetMapping("/testBB")
    private String testBB(){
        return "testBB";
    }

    @GetMapping("/testCC")
    private String testCC() throws Exception{
//        int i=10/0;
        Thread.sleep(1000);
        System.out.println("testCC......");
        return "testCC";
    }

    @GetMapping(value = "/testHotKey")
//    value为命名的资源名，blockHandler定义的是兜底的方法
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "testHotKey...";
    }
    public String deal_testHotKey(String p1, String p2, BlockException blockException){
        return "deal_testHotKey";
    }


    @GetMapping(value = "/testHotKey2")
//    value为命名的资源名，blockHandler定义的是兜底的方法
    @SentinelResource(value = "testHotKey2",
            blockHandlerClass = CustomerHandler.class,
            blockHandler = "customerHandler2")
    public String testHotKey2(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "testHotKey2...";
    }



}
