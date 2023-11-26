package com.ram.msgcenter.handler.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.ram.msgcenter.domain.AnchorInfo;
import com.ram.msgcenter.domain.LogParam;
import com.ram.msgcenter.domain.TaskInfo;
import com.ram.msgcenter.enums.AnchorState;
import com.ram.msgcenter.handler.pending.Task;
import com.ram.msgcenter.handler.pending.TaskPendingHolder;
import com.ram.msgcenter.handler.service.ConsumeService;
import com.ram.msgcenter.handler.utils.GroupIdMappingUtils;
import com.ram.msgcenter.support.domain.MessageTemplate;
import com.ram.msgcenter.support.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ramxx
 */
@Service
public class ConsumeServiceImpl implements ConsumeService {
    private static final String LOG_BIZ_TYPE = "Receiver#consumer";
    private static final String LOG_BIZ_RECALL_TYPE = "Receiver#recall";
    @Autowired
    private ApplicationContext context;

    @Autowired
    private TaskPendingHolder taskPendingHolder;

    @Autowired
    private LogUtils logUtils;


    @Override
    public void consume2Send(List<TaskInfo> taskInfoLists) {
        String topicGroupId = GroupIdMappingUtils.getGroupIdByTaskInfo(CollUtil.getFirst(taskInfoLists.iterator()));
        for (TaskInfo taskInfo : taskInfoLists) {
            Task task = context.getBean(Task.class).setTaskInfo(taskInfo);
            logUtils.print(LogParam.builder().bizType(LOG_BIZ_TYPE).object(taskInfo).build(),
                    AnchorInfo.builder().ids(taskInfo.getReceiver()).businessId(taskInfo.getBusinessId()).state(AnchorState.RECEIVE.getCode()).build());
            taskPendingHolder.route(topicGroupId).execute(task);
        }
    }

    @Override
    public void consume2recall(MessageTemplate messageTemplate) {
        logUtils.print(LogParam.builder().bizType(LOG_BIZ_RECALL_TYPE).object(messageTemplate).build());
    }
}
