package com.ram.msgcenter.web;

import com.alibaba.fastjson.JSON;
import com.ram.msgcenter.support.dao.MessageTemplateDao;
import com.ram.msgcenter.support.domain.MessageTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/test")
    private String test(){
        System.out.println("sout: sout测试");
        log.info("log：log测试");
        return "测试测试测试";
    }

    @RequestMapping("/database")
    private String testDataBase() {
        List<MessageTemplate> list = messageTemplateDao.findAllByIsDeletedEquals(0, PageRequest.of(0, 10));
        return JSON.toJSONString(list);
    }

}
