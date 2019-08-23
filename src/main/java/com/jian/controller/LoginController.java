package com.jian.controller;

import com.jian.domian.User;
import com.jian.service.UserService;
import com.jian.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Lizj
 * @date 2019/8/23 12:35
 */
@WebServlet(name = "/loginServlet", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private UserService userService = new UserServiceImpl(); //依赖于业务类

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //得到用户名和密码
//        String username = request.getParameter("username"); //一定要与表单的名字相同
//        String password = request.getParameter("password");

        User user = new User();

        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user.getUsername());
        if (user.getUsername() != null && user.getPassword() != null) {
            //调用业务层登录的方法实现登录
            User login = userService.login(user);

            //如果登录成功，放到请求域中
            if (login != null) {
                //登录成功，重定向到成功页面
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            } else {
                //登录失败，重定向到失败页面
                response.sendRedirect(request.getContextPath() + "/fail.jsp");
            }
        } else {
            return;
        }
    }
}
