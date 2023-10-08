package com.ram.msgcenter.service.api.impl.domain;

import com.ram.msgcenter.domain.TaskInfo;
import com.ram.msgcenter.support.domain.MessageTemplate;
import com.ram.msgcenter.support.pipeline.ProcessModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ramxx
 * @description 发送消息任务模型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendTaskModel implements ProcessModel {

    /**
     * 消息模板Id
     */
    private Long messageTemplateId;

    /**
     * 请求参数
     */
    private List<MessageParam> messageParamList;

    /**
     * 发送任务的信息
     */
    private List<TaskInfo> taskInfo;

    /**
     * 撤回任务的信息
     */
    private MessageTemplate messageTemplate;

}
