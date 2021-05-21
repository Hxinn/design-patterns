package com.hxinn.opensource.designpatterns.proxy.java;

import com.hxinn.opensource.designpatterns.common.UserVO;

public interface IUserController {

    UserVO login(String name, String password);

    UserVO register(String name, Integer age, Integer sex);
}
