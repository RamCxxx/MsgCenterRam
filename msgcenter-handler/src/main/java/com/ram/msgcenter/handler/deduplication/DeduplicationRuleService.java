package com.ram.msgcenter.handler.deduplication;

import com.ram.msgcenter.constant.CommonConstant;
import com.ram.msgcenter.domain.TaskInfo;
import com.ram.msgcenter.enums.DeduplicationType;
import com.ram.msgcenter.support.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author ramxx
 * 去重服务
 */
@Service
public class DeduplicationRuleService {

    public static final String DEDUPLICATION_RULE_KEY = "deduplicationRule";

    @Autowired
    private ConfigService config;

    @Autowired
    private DeduplicationHolder deduplicationHolder;

    public void duplication(TaskInfo taskInfo) {
        // 配置样例：{"deduplication_10":{"num":1,"time":300},"deduplication_20":{"num":5}}
        String deduplicationConfig = config.getProperty(DEDUPLICATION_RULE_KEY, CommonConstant.EMPTY_JSON_OBJECT);
        //String deduplicationConfig = "{\"deduplication_10\":{\"num\":1,\"time\":300},\"deduplication_20\":{\"num\":5}}";

        // 去重
        List<Integer> deduplicationList = DeduplicationType.getDeduplicationList();
        for (Integer deduplicationType : deduplicationList) {
            DeduplicationParam deduplicationParam = deduplicationHolder.selectBuilder(deduplicationType).build(deduplicationConfig, taskInfo);
            if (Objects.nonNull(deduplicationParam)) {
                deduplicationHolder.selectService(deduplicationType).deduplication(deduplicationParam);
            }
        }
    }


}
