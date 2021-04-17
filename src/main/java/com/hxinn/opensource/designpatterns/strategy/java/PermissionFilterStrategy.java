package com.hxinn.opensource.designpatterns.strategy.java;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PermissionFilterStrategy {


    /**
     * 根据查询条件过滤权限
     *
     * @param allPermissions  权限列表
     * @param permissionQuery 查询条件
     * @return 过滤后的权限
     */
    public List<String> filterPermission(List<String> allPermissions, PermissionQuery permissionQuery) {
        List<Pair<Predicate<PermissionQuery>, BiFunction<List<String>, PermissionQuery, List<String>>>> chains = new ArrayList<>();

        //内部用户和外部用户ALL返回全部
        chains.add(Pair.of(query -> "ALL".equalsIgnoreCase(query.getType()), (permissions, query) -> permissions));

        //外部用户处理 非ALL的情况下,外部用户一次只能查看一种权限的数据
        chains.add(Pair.of(query -> new Integer(1).equals(query.getUserType()), (permissions, query) -> permissions.stream()
                .filter(q -> StringUtils.equalsIgnoreCase(q, query.getPowerName())).collect(Collectors.toList())));

        //内部用户处理逻辑
        //内部用户可以查看 类型  权限 如果PowerName不为null (以PowerName为前缀)
        chains.add(Pair.of(query -> new Integer(1).equals(query.getUserType()) && StringUtils.isNoneBlank(query.getPowerName()),
                (permissions, query) -> permissions.stream()
                        .filter(s -> StringUtils.startsWithIgnoreCase(s, query.getPowerName()))
                        .collect(Collectors.toList())));

        //最后增加一个收尾的策略 其他情况统一返回原全量权限
        chains.add(Pair.of(query -> true, (powers, query) -> powers));

        //使用策略
        for (Pair<Predicate<PermissionQuery>, BiFunction<List<String>, PermissionQuery, List<String>>> chain : chains) {
            if (chain.getFirst().test(permissionQuery)) {
                return chain.getSecond().apply(allPermissions, permissionQuery);
            }
        }

        return allPermissions;
    }
}
