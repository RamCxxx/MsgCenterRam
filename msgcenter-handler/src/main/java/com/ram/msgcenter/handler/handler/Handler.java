package com.ram.msgcenter.handler.handler;

import com.ram.msgcenter.domain.TaskInfo;
import com.ram.msgcenter.support.domain.MessageTemplate;

/**
 * @author ramxx
 * 消息处理器
 */
public interface Handler {

    /**
     * 处理器
     *
     * @param taskInfo
     */
    void doHandler(TaskInfo taskInfo);

    /**
     * 撤回消息
     *
     * @param messageTemplate
     * @return
     */
    void recall(MessageTemplate messageTemplate);

}
