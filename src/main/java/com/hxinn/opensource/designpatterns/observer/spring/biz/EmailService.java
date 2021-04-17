package com.hxinn.opensource.designpatterns.observer.spring.biz;

import com.hxinn.opensource.designpatterns.observer.spring.UserRegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService {

    @EventListener
    public void sendEmail(UserRegisterEvent event){
        log.info("发送邮件给用户[{}]",event.getUsername());
    }
}
