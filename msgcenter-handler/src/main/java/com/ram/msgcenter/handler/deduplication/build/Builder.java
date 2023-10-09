package com.ram.msgcenter.handler.deduplication.build;

import com.ram.msgcenter.domain.TaskInfo;
import com.ram.msgcenter.handler.deduplication.DeduplicationParam;

/**
 * @author ramxx
 */
public interface Builder {

    String DEDUPLICATION_CONFIG_PRE = "deduplication_";

    /**
     * 根据配置构建去重参数
     *
     * @param deduplication
     * @param taskInfo
     * @return
     */
    DeduplicationParam build(String deduplication, TaskInfo taskInfo);
}
