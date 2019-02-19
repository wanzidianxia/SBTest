package com.springboot.test.demo.chapter5.service;

import com.springboot.test.demo.chapter5.enumeration.SexEnum;
import com.springboot.test.demo.chapter5.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;

public class JdbcTmplUserServiceImpl implements JdbcTmplUserService {
    @Autowired
    private JdbcTemplate jdbcTemplate = null;

    private RowMapper<User> getUserRowMapper() {
        RowMapper<User> userRowMapper = (ResultSet rs, int rownum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("user_name"));
            int sexId = rs.getInt("sex");
            SexEnum sex = SexEnum.getEnumById(sexId);
            user.setSex(sex);
            user.setNote(rs.getString("note"));
            return user;
        };
        return userRowMapper;
    }

    @Override
    public User getUser(Long id) {
        String sql = "select id,user_name,sex,note from t_user  where id=?";
        Object[] params = new Object[]{id};
        User user = jdbcTemplate.queryForObject(sql, params, getUserRowMapper());
        return user;
    }

    @Override
    public List<User> findUsers(String userName, String note) {
        String sql = "select id,user_name,sex,note from t_user "
                + "where user_name like concat('%',?,'%')"
                + " and note like concat ('%',?,'%')";
        Object[] params = new Object[]{userName, note};
        List<User> userList = jdbcTemplate.query(sql, params, getUserRowMapper());
        return userList;
    }

    @Override
    public int insertUser(User user) {
        String sql = " insert into t_user (user_name,sex,note) values (?, ?, ?) ";
        return jdbcTemplate.update(sql,
                user.getUserName(), user.getSex().getId(), user.getNote());
    }

    @Override
    public int updateUser(User user) {
        String sql = " update t_user set user_name =?,sex=?,note=? "
                + "where  id=?";
        return jdbcTemplate.update(sql, user.getUserName(),
                user.getSex().getId(), user.getNote(), user.getId());
    }

    @Override
    public int deleteUser(Long id) {
        String sql = "delete from t user where id=?";
        return jdbcTemplate.update(sql, id);
    }
}