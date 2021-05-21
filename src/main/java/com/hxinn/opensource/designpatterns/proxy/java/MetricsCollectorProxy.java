package com.hxinn.opensource.designpatterns.proxy.java;

import com.hxinn.opensource.designpatterns.common.RequestInfo;
import com.hxinn.opensource.designpatterns.common.UserVO;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 基于JDK的动态代理
 */
public class MetricsCollectorProxy {

    /**
     * 创建代理对象
     * @param proxyObj 原始类
     * @return 代理类
     */
    public Object createProxy(Object proxyObj){
        Class<?>[] interfaces = proxyObj.getClass().getInterfaces();
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(proxyObj);
        return Proxy.newProxyInstance(proxyObj.getClass().getClassLoader(),interfaces,dynamicProxyHandler);
    }

    /**
     * JDK 动态代理
     */
    private class DynamicProxyHandler implements InvocationHandler{
        private final Object proxiedObject;
        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long startTimestamp = System.currentTimeMillis();
            Object result = method.invoke(proxiedObject, args);
            long endTimestamp = System.currentTimeMillis();
            long responseTime = endTimestamp - startTimestamp;
            String apiName = proxiedObject.getClass().getName() + ":" + method.getName();
            RequestInfo requestInfo = new RequestInfo(apiName, startTimestamp, responseTime);
            System.out.println(requestInfo);
            return result;
        }
    }

    public static void main(String[] args) {
        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        IUserController userController = (IUserController)proxy.createProxy(new UserController());
        UserVO userVO = userController.login("张三", "234");
        System.out.println(userVO);
        UserVO register = userController.register("李四", 18, 1);
        System.out.println(register);
    }
}
