package com.ram.msgcenter.support.mq.eventbus;

import com.ram.msgcenter.domain.TaskInfo;
import com.ram.msgcenter.support.domain.MessageTemplate;

import java.util.List;

/**
 * @author ramxx
 * 监听器
 */
public interface EventBusListener {


    /**
     * 消费消息
     * @param lists
     */
    void consume(List<TaskInfo> lists);

    /**
     * 撤回消息
     * @param messageTemplate
     */
    void recall(MessageTemplate messageTemplate);
}
