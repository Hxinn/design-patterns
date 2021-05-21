package com.hxinn.opensource.designpatterns.proxy.java;

import com.hxinn.opensource.designpatterns.common.RequestInfo;
import com.hxinn.opensource.designpatterns.common.UserVO;

/**
 * 静态代理
 * 基于接口实现 将原始类对象替换为代理类对象
 * 实现对用户请求的代理
 */
public class UserControllerProxy implements IUserController{

    private final UserController userController;

    public UserControllerProxy(UserController userController) {
        this.userController = userController;
    }

    @Override
    public UserVO login(String name, String password) {
        long starTimestamp = System.currentTimeMillis();
        UserVO login = userController.login(name, password);
        long endTimestamp = System.currentTimeMillis();
        long responseTime = endTimestamp - starTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", starTimestamp, responseTime);
        System.out.println(requestInfo);
        return login;
    }

    @Override
    public UserVO register(String name, Integer age, Integer sex) {
        long starTimestamp = System.currentTimeMillis();
        UserVO register = userController.register(name, age, sex);
        long endTimestamp = System.currentTimeMillis();
        long responseTime = endTimestamp - starTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", starTimestamp, responseTime);
        System.out.println(requestInfo);
        return register;
    }

    public static void main(String[] args) {
        UserControllerProxy userControllerProxy = new UserControllerProxy(new UserController());
        UserVO userVO = userControllerProxy.login("张三", "123");
        System.out.println("login"+userVO);
        UserVO register = userControllerProxy.register("李四", 15, 1);
        System.out.println("register"+register);
    }
}
