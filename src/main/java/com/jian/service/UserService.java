package com.jian.service;

import com.jian.dao.UserDao;
import com.jian.domian.User;

/**
 * @author Lizj
 * @date 2019/8/23 12:34
 */
public interface UserService {
    User login(User user);
}
