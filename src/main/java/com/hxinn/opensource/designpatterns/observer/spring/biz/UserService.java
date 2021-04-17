package com.hxinn.opensource.designpatterns.observer.spring.biz;

import com.hxinn.opensource.designpatterns.observer.spring.UserRegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void register(String name){
        log.info("注册逻辑[{}]",name);
        applicationEventPublisher.publishEvent(new UserRegisterEvent(this,name));

    }
}
