package com.ram.msgcenter.support.pipeline;

/**
 * 业务执行器
 *
 * @author ramxx
 */
public interface BusinessProcess<T extends ProcessModel> {

    /**
     * 真正处理逻辑
     * @param context
     */
    void process(ProcessContext<T> context);
}
