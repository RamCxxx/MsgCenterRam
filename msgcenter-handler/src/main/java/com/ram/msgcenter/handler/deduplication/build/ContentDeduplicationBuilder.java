package com.ram.msgcenter.handler.deduplication.build;

import com.ram.msgcenter.domain.TaskInfo;
import com.ram.msgcenter.enums.AnchorState;
import com.ram.msgcenter.enums.DeduplicationType;
import com.ram.msgcenter.handler.deduplication.DeduplicationParam;
import org.springframework.stereotype.Service;

import java.util.Objects;


/**
 * @author ramxx
 */
@Service
public class ContentDeduplicationBuilder extends AbstractDeduplicationBuilder implements Builder {

    public ContentDeduplicationBuilder() {
        deduplicationType = DeduplicationType.CONTENT.getCode();
    }

    @Override
    public DeduplicationParam build(String deduplication, TaskInfo taskInfo) {
        DeduplicationParam deduplicationParam = getParamsFromConfig(deduplicationType, deduplication, taskInfo);
        if (Objects.isNull(deduplicationParam)) {
            return null;
        }
        deduplicationParam.setAnchorState(AnchorState.CONTENT_DEDUPLICATION);
        return deduplicationParam;

    }
}
