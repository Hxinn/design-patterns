package com.hxinn.opensource.designpatterns.proxy.java;

import com.hxinn.opensource.designpatterns.common.UserVO;

import java.util.concurrent.TimeUnit;

/**
 * 实现记录对api调用耗时
 */
public class UserController implements IUserController{

    public UserVO login(String name,String password){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new UserVO(name,10,1);
    }

    public UserVO register(String name, Integer age, Integer sex){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new UserVO(name,age,sex);
    }
}
