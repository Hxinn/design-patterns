package com.hxinn.opensource.designpatterns.strategy;

/**
 * 业务类型
 */
public enum BizType {

    COLD_START(1),
    TREND(2);


    private final Integer code;

    BizType(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
