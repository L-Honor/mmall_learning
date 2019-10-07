package com.mmall.service;

import com.mmall.commom.ServerResponse;
import com.mmall.pojo.User;

public interface IUserService {
    ServerResponse<User> login(String username, String password);
    ServerResponse<String> register(User user);
    ServerResponse<String> checkValid(String str,String type);
    ServerResponse selectQuestion(String username);
    ServerResponse<String> checkAnswer(String username,String question,String answer);
    //忘记密码中重置密码功能的Service层接口
    ServerResponse<String> forgetResetPassword(String username,String passwordNew,String forgetToken);
    //登录状态下的重置密码功能开发Service层接口
    ServerResponse<String> resetPassword(String passwordOld,String passwordNew,User user);

    //登录状态下更新用户个人信息接口Service层
    ServerResponse<User> updateInformation(User user);

    //登录状态下获取用户详细信息功能Service接口
    ServerResponse<User> getInformation(Integer userId);

    //校验是否是管理员
    ServerResponse checkAdminRole(User user);
}
