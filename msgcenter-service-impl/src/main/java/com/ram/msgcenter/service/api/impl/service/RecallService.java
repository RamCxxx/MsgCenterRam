package com.ram.msgcenter.service.api.impl.service;

import com.ram.msgcenter.service.api.impl.domain.SendRequest;
import com.ram.msgcenter.service.api.impl.domain.SendResponse;

/**
 * 撤回接口
 *
 * @author ramxx
 */
public interface RecallService {


    /**
     * 根据模板ID撤回消息
     *
     * @param sendRequest
     * @return
     */
    SendResponse recall(SendRequest sendRequest);
}
