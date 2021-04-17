package com.hxinn.opensource.designpatterns.strategy.spring.biz;

import com.hxinn.opensource.designpatterns.strategy.BizType;
import com.hxinn.opensource.designpatterns.strategy.spring.PermissionCheckHandler;
import org.springframework.stereotype.Component;

@Component
public class TrendPermissionCheckHandlerImpl implements PermissionCheckHandler {


    @Override
    public String getBizType() {
        return BizType.TREND.name();
    }

    @Override
    public void permissionCheck() {
        System.out.println("TrendPermissionCheck.......");
    }
}
