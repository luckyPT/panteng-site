package com.site.panteng.dao;

import com.site.panteng.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by panteng on 2017/4/8.
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean addUser(User user){
        try {

        }catch (Exception e){

        }
        return false;
    }

    public User getUserByNickName(String nickName){
        String sql = "select * from User where nickName = '" + nickName + "'";
        User user = null;
        try {
           user = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class));
        }catch (Exception e){
            //e.printStackTrace();
        }
        return user;
    }
}
