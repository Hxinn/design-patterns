package com.hxinn.opensource.designpatterns.strategy.spring.biz;

import com.hxinn.opensource.designpatterns.strategy.BizType;
import com.hxinn.opensource.designpatterns.strategy.spring.PermissionCheckHandler;
import org.springframework.stereotype.Component;

@Component
public class ColdStartPermissionCheckHandlerImpl implements PermissionCheckHandler {

    @Override
    public String getBizType() {
        return BizType.COLD_START.name();
    }

    @Override
    public void permissionCheck() {
        //业务特有鉴权逻辑
        System.out.println("ColdStartPermissionCheck.......");
    }
}
