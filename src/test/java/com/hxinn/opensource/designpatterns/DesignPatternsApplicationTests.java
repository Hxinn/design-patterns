package com.hxinn.opensource.designpatterns;

import com.hxinn.opensource.designpatterns.observer.spring.biz.UserService;
import com.hxinn.opensource.designpatterns.strategy.BizType;
import com.hxinn.opensource.designpatterns.strategy.spring.PermissionCheckService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DesignPatternsApplicationTests {
    @Autowired
    private PermissionCheckService permissionCheckService;

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        permissionCheckService.permissionCheck(BizType.TREND);
    }

    @Test
    void eventListener(){
        userService.register("perter");
    }
}
