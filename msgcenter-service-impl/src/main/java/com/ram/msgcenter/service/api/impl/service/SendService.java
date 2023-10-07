package com.ram.msgcenter.service.api.impl.service;

import com.ram.msgcenter.service.api.impl.domain.BatchSendRequest;
import com.ram.msgcenter.service.api.impl.domain.SendRequest;
import com.ram.msgcenter.service.api.impl.domain.SendResponse;

/**
 * 发送接口
 *
 * @author ramxx
 */
public interface SendService {

    /**
     * 单文案发送接口
     *
     * @param sendRequest
     * @return
     */
    SendResponse send(SendRequest sendRequest);


    /**
     * 多文案发送接口
     *
     * @param batchSendRequest
     * @return
     */
    SendResponse batchSend(BatchSendRequest batchSendRequest);

}
