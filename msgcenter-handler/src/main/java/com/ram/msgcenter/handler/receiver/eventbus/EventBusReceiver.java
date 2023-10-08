package com.ram.msgcenter.handler.receiver.eventbus;

import com.google.common.eventbus.Subscribe;

import com.ram.msgcenter.domain.TaskInfo;
import com.ram.msgcenter.handler.service.ConsumeService;
import com.ram.msgcenter.support.constants.MessageQueuePipeline;
import com.ram.msgcenter.support.domain.MessageTemplate;
import com.ram.msgcenter.support.mq.eventbus.EventBusListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Component
@ConditionalOnProperty(name = "msgCenter.mq.pipeline", havingValue = MessageQueuePipeline.EVENT_BUS)
@Slf4j
public class EventBusReceiver implements EventBusListener {

    @Autowired
    private ConsumeService consumeService;



    @Override
    @Subscribe
    public void consume(List<TaskInfo> lists) {
        //log.error(JSON.toJSONString(lists));
        consumeService.consume2Send(lists);
    }

    @Override
    @Subscribe
    public void recall(MessageTemplate messageTemplate){

    }
}
