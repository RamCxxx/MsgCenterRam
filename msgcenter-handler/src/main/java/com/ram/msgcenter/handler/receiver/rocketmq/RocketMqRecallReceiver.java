package com.ram.msgcenter.handler.receiver.rocketmq;

import com.alibaba.fastjson.JSON;

import com.ram.msgcenter.handler.service.ConsumeService;
import com.ram.msgcenter.support.constants.MessageQueuePipeline;
import com.ram.msgcenter.support.domain.MessageTemplate;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @author ramxx
 * 撤回消息类型的实现
 */
@Component
@ConditionalOnProperty(name = "msgcenter.mq.pipeline", havingValue = MessageQueuePipeline.ROCKET_MQ)
@RocketMQMessageListener(topic = "${msgcenter.business.recall.topic.name}",
        consumerGroup = "${msgcenter.rocketmq.recall.consumer.group}",
        selectorType = SelectorType.TAG,
        selectorExpression = "${msgcenter.business.tagId.value}"
)
public class RocketMqRecallReceiver implements RocketMQListener<String> {

    @Autowired
    private ConsumeService consumeService;


    @Override
    public void onMessage(String message) {
        if (StringUtils.isBlank(message)) {
            return;
        }
        MessageTemplate messageTemplate = JSON.parseObject(message, MessageTemplate.class);
        consumeService.consume2recall(messageTemplate);
    }
}
