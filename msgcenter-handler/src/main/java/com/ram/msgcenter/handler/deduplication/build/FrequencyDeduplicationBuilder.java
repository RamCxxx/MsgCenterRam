package com.ram.msgcenter.handler.deduplication.build;

import cn.hutool.core.date.DateUtil;
import com.ram.msgcenter.domain.TaskInfo;
import com.ram.msgcenter.enums.AnchorState;
import com.ram.msgcenter.enums.DeduplicationType;
import com.ram.msgcenter.handler.deduplication.DeduplicationParam;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * @author ramxx
 */

@Service
public class FrequencyDeduplicationBuilder extends AbstractDeduplicationBuilder implements Builder {
    public FrequencyDeduplicationBuilder() {
        deduplicationType = DeduplicationType.FREQUENCY.getCode();
    }

    @Override
    public DeduplicationParam build(String deduplication, TaskInfo taskInfo) {
        DeduplicationParam deduplicationParam = getParamsFromConfig(deduplicationType, deduplication, taskInfo);
        if (Objects.isNull(deduplicationParam)) {
            return null;
        }
        deduplicationParam.setDeduplicationTime((DateUtil.endOfDay(new Date()).getTime() - DateUtil.current()) / 1000);
        deduplicationParam.setAnchorState(AnchorState.RULE_DEDUPLICATION);
        return deduplicationParam;
    }
}
