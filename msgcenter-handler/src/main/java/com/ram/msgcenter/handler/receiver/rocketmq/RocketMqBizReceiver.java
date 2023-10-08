package com.ram.msgcenter.handler.receiver.rocketmq;

import com.alibaba.fastjson.JSON;
import com.ram.msgcenter.domain.TaskInfo;
import com.ram.msgcenter.support.constants.MessageQueuePipeline;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author ramxx
 * 接受消息调用服务发送到MQ
 */
@Component
@ConditionalOnProperty(name = "msgcenter.mq.pipeline", havingValue = MessageQueuePipeline.ROCKET_MQ)
@RocketMQMessageListener(topic = "${msgcenter.business.topic.name}",
        consumerGroup = "${msgcenter.rocketmq.biz.consumer.group}",
        selectorType = SelectorType.TAG,
        selectorExpression = "${msgcenter.business.tagId.value}"
)
@Slf4j
public class RocketMqBizReceiver implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        if (StringUtils.isBlank(message)) {
            return;
        }
        List<TaskInfo> taskInfoLists = JSON.parseArray(message, TaskInfo.class);
        log.info("groupId:{},params:{}", message, JSON.toJSONString(taskInfoLists));
        //TODO 服务未实现
    }
}
