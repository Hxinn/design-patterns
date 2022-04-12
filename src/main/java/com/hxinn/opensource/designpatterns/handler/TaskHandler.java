package com.hxinn.opensource.designpatterns.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * xxxx
 *
 * @author admin
 * @createTime 2022-04-12
 */
@Slf4j
@Component
public class TaskHandler implements ApplicationContextAware {



    public void handler() {
      log.info("do handler");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("application context");
    }
}
