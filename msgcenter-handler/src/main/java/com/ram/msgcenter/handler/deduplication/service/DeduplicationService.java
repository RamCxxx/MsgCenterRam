package com.ram.msgcenter.handler.deduplication.service;

import com.ram.msgcenter.handler.deduplication.DeduplicationParam;

/**
 * @author ramxx
 */
public interface DeduplicationService {

    /**
     * 去重
     *
     * @param param
     */
    void deduplication(DeduplicationParam param);
}
