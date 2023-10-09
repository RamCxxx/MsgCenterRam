package com.ram.msgcenter.handler.deduplication.limit;

import com.ram.msgcenter.domain.TaskInfo;
import com.ram.msgcenter.handler.deduplication.DeduplicationParam;
import com.ram.msgcenter.handler.deduplication.service.AbstractDeduplicationService;

import java.util.Set;

/**
 * @author ramxx
 */
public interface LimitService {


    /**
     * 去重限制
     *
     * @param service  去重器对象
     * @param taskInfo
     * @param param    去重参数
     * @return 返回不符合条件的手机号码
     */
    Set<String> limitFilter(AbstractDeduplicationService service, TaskInfo taskInfo, DeduplicationParam param);

}
