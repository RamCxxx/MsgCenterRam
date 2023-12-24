package com.ram.msgcenter.web.controller;

import com.alibaba.fastjson.JSON;
import com.ram.msgcenter.service.api.impl.domain.MessageParam;
import com.ram.msgcenter.service.api.impl.domain.SendRequest;
import com.ram.msgcenter.service.api.impl.domain.SendResponse;
import com.ram.msgcenter.service.api.impl.enums.BusinessCode;
import com.ram.msgcenter.service.api.impl.service.SendService;
import com.ram.msgcenter.support.dao.MessageTemplateDao;
import com.ram.msgcenter.support.domain.MessageTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

/**
 * @author ramxx
 * 测试接口
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private MessageTemplateDao messageTemplateDao;
    @Autowired
    private SendService sendService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/test")
    private String test(){
        System.out.println("sout: sout测试");
        log.info("log：log测试");
        return "测试测试测试";
    }

    @RequestMapping("/database")
    private String testDataBase() {
        List<MessageTemplate> list = messageTemplateDao.findAllByIsDeletedEqualsOrderByUpdatedDesc(0, PageRequest.of(0, 10));
        return JSON.toJSONString(list);
    }
    @RequestMapping("/send")
    private String testSend() {
        SendRequest sendRequest = SendRequest.builder()
                .code(BusinessCode.COMMON_SEND.getCode())
                .messageTemplateId(1L)
                .messageParam(MessageParam.builder().receiver("2848428570@qq.com").build()).build();

        SendResponse response = sendService.send(sendRequest);
        return JSON.toJSONString(response);

    }

    @RequestMapping("/redis")
    private String testRedis() {
        stringRedisTemplate.opsForValue().set("ramxx", "msgcenter");
        return stringRedisTemplate.opsForValue().get("ramxx");
    }


}
