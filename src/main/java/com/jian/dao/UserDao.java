package com.jian.dao;


import com.jian.domian.User;
import com.jian.utils.DataSourceUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Lizj
 * @date 2019/8/23 12:31
 */
public class UserDao {

    //创建模板对象
    private JdbcTemplate template = new JdbcTemplate(DataSourceUtil.getDataSource());

    /**
     * 通过用户名和密码查询某个用户
     */
    public User findUser(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        if (username != null && password != null) {
            try {
                return template.queryForObject("select * from user where username=? and password=?",
                        new BeanPropertyRowMapper<>(User.class), username, password);
            } catch (DataAccessException e) {
                return null;
            }
        } else {
            return null;
        }

    }
}
