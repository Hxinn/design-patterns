package com.hxinn.opensource.designpatterns.strategy.spring;

import com.hxinn.opensource.designpatterns.strategy.BizType;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现ApplicationContextAware 获取applicationContext
 * InitializingBean 方便定制初始化
 */
@Component
public class PermissionCheckFactory implements ApplicationContextAware, InitializingBean {

    private static final Map<String,PermissionCheckHandler> PERMISSION_CHECK_HANDLER_MAP = new HashMap<>();

    private ApplicationContext context;

    /**
     * 根据业务类型返回对应的处理器
     * @param bizType   业务类型
     * @return  对应业务处理器
     */
    public PermissionCheckHandler getHandler(BizType bizType){
        return PERMISSION_CHECK_HANDLER_MAP.get(bizType.name());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        context.getBeansOfType(PermissionCheckHandler.class)
                .values()
                .forEach(handler -> PERMISSION_CHECK_HANDLER_MAP.put(handler.getBizType(),handler));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
