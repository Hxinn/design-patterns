package com.hxinn.opensource.designpatterns.strategy.spring;

import com.hxinn.opensource.designpatterns.strategy.BizType;
import org.springframework.stereotype.Service;

@Service
public class PermissionCheckService {

    private final PermissionCheckFactory permissionCheckFactory;

    public PermissionCheckService(PermissionCheckFactory permissionCheckFactory) {
        this.permissionCheckFactory = permissionCheckFactory;
    }


    public void permissionCheck(BizType bizType){
        PermissionCheckHandler handler = permissionCheckFactory.getHandler(bizType);
        handler.permissionCheck();
    }

}
