package com.ram.msgcenter.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ramxx
 * 测试接口
 */
@RestController
public class TestController {
    @RequestMapping("/test")
    private String test(){
        return "测试测试测试";
    }
}
