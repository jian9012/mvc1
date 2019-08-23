package com.jian.service.impl;

import com.jian.dao.UserDao;
import com.jian.domian.User;
import com.jian.service.UserService;

/**
 * @author Lizj
 * @date 2019/8/23 13:46
 */
public class UserServiceImpl implements UserService{
    //依赖于dao层
    private UserDao userDao = new UserDao();
    //业务方法：登录
    public User login(User user) {
        if (user.getUsername()!=null&&user.getPassword()!=null){
            return userDao.findUser(user);
        }else {
            return null;
        }
    }
}
