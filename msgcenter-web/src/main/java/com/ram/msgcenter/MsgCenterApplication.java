package com.ram.msgcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author ramxx
 */
@SpringBootApplication
public class MsgCenterApplication {
    public static void main(String[] args) {

        /**
         * 如果你需要启动Apollo动态配置
         * 1、启动apollo
         * 2、将application.properties配置文件的 msgcenter.apollo.enabled 改为true
         * 3、下方的property替换真实的ip和port
         */
        System.setProperty("apollo.config-service", "http://msgcenter-apollo-config:8080");

        SpringApplication.run(MsgCenterApplication.class, args);
    }
}
