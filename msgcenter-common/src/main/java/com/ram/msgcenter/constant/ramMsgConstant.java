package com.ram.msgcenter.constant;


/**
 * 基础的常量信息
 *
 * @author ramxx
 */
public class ramMsgConstant {

    /**
     * businessId默认的长度
     * 生成的逻辑：com.ram.msgcenter.support.utils.TaskInfoUtils#generateBusinessId(java.lang.Long, java.lang.Integer)
     */
    public final static Integer BUSINESS_ID_LENGTH = 16;

    /**
     * 接口限制 最多的人数
     */
    public static final Integer BATCH_RECEIVER_SIZE = 100;

    /**
     * 消息发送给全部人的标识
     * (企业微信 应用消息)
     * (钉钉自定义机器人)
     * (钉钉工作消息)
     */
    public static final String SEND_ALL = "@all";



    /**
     * 默认的常量，如果新建模板/账号时，没传入则用该常量
     */
    public static final String DEFAULT_CREATOR = "Ramxx";
    public static final String DEFAULT_UPDATOR = "Ramxx";
    public static final String DEFAULT_TEAM = "Ramxx";
    public static final String DEFAULT_AUDITOR = "Ramxx";


}
