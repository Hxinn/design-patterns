package com.hxinn.opensource.designpatterns.observer.spring.biz;

import com.hxinn.opensource.designpatterns.observer.spring.UserRegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CouponService {

    @EventListener
    public void addCoupon(UserRegisterEvent event){
        log.info("给用户[{}]发放优惠券",event.getUsername());
    }
}
