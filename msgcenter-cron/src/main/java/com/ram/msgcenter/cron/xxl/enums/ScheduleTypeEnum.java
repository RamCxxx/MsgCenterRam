package com.ram.msgcenter.cron.xxl.enums;

/**
 * 调度类型
 *
 * @author Ramxx
 */
public enum ScheduleTypeEnum {

    /**
     * NONE
     */
    NONE,
    /**
     * schedule by cron
     */
    CRON,

    /**
     * schedule by fixed rate (in seconds)
     */
    FIX_RATE;

    ScheduleTypeEnum() {
    }

}
