package com.hxinn.opensource.designpatterns.strategy.spring;


/**
 * 业务权限校验处理器
 * 不同业务有各自的鉴权方式
 */
public interface PermissionCheckHandler {

    String getBizType();

    void permissionCheck();
}
