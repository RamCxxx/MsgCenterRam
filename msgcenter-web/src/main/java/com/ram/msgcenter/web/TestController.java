package com.ram.msgcenter.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ramxx
 * 测试接口
 */
@RestController
@Slf4j
public class TestController {
    @RequestMapping("/test")
    private String test(){
        System.out.println("sout: sout测试");
        log.info("log：log测试");
        return "测试测试测试";
    }
}
