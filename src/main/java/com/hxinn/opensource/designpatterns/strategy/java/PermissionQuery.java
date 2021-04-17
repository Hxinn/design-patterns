package com.hxinn.opensource.designpatterns.strategy.java;

import lombok.Data;

/**
 * 权限查询
 */
@Data
public class PermissionQuery {

    /**
     * All-全部
     * 其他值-无效
     *
     */
    private String type;

    /**
     * 0-内部用户
     * 1-外部用户
     */
    private Integer userType;

    /**
     * 如果不是ALL角度查看
     * 外部用户一次只能查看一个权限
     */
    private String powerName;

}
