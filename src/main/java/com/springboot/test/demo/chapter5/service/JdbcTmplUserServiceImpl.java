package com.springboot.test.demo.chapter5.service;

import com.springboot.test.demo.chapter5.enumeration.SexEnum;
import com.springboot.test.demo.chapter5.pojo.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class JdbcTmplUserServiceImpl implements JdbcTmplUserService {
    @Autowired
    private JdbcTemplate jdbcTemplate = null;

    private RowMapper<UserJpa> getUserRowMapper() {
        RowMapper<UserJpa> userRowMapper = (ResultSet rs, int rownum) -> {
            UserJpa user = new UserJpa();
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
    public UserJpa getUser(Long id) {
        String sql = "select id,user_name,sex,note from t_user  where id=?";
        Object[] params = new Object[]{id};
        UserJpa user = jdbcTemplate.queryForObject(sql, params, getUserRowMapper());
        return user;
    }

    @Override
    public UserJpa getUser2(Long id) {
        UserJpa result = this.jdbcTemplate.execute((Statement smt) -> {
            String sql1 = "select count(*)  total from t_user where  id=" + id;
            ResultSet rs1 = smt.executeQuery(sql1);
            while (rs1.next()) {
                int total = rs1.getInt("total");
                System.out.println(total);
            }
            String sql2 = "select  id,user_name,sex,note  from t_user"
                    + " where  id=" + id;
            ResultSet rs2 = smt.executeQuery(sql2);
            UserJpa user = null;
            while (rs2.next()) {
                int rowNum = rs2.getRow();
                user = getUserRowMapper().mapRow(rs2, rowNum);
            }
            return user;

        });
        return result;
    }

    @Override
    public UserJpa getUser3(Long id) {
        return this.jdbcTemplate.execute((Connection conn) -> {
            String sql1 = "select count(*)  total from t_user where  id=?";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setLong(1, id);
            ResultSet rs1 = ps1.executeQuery();
            while (rs1.next()) {
                System.out.println(rs1.getInt("total"));
            }
            String sql2 = "select  id,user_name,sex,note  from t_user"
                    + " where  id=?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setLong(1, id);
            ResultSet rs2 = ps2.executeQuery();
            UserJpa user = null;
            while (rs2.next()) {
                int rowNum = rs2.getRow();
                user = getUserRowMapper().mapRow(rs2, rowNum);
            }
            return user;

        });

    }


    @Override
    public List<UserJpa> findUsers(String userName, String note) {
        String sql = "select id,user_name,sex,note from t_user "
                + "where user_name like concat('%',?,'%')"
                + " and note like concat ('%',?,'%')";
        Object[] params = new Object[]{userName, note};
        List<UserJpa> userList = jdbcTemplate.query(sql, params, getUserRowMapper());
        return userList;
    }

    @Override
    public int insertUser(UserJpa user) {
        String sql = " insert into t_user (user_name,sex,note) values (?, ?, ?) ";
        return jdbcTemplate.update(sql,
                user.getUserName(), user.getSex().getId(), user.getNote());
    }

    @Override
    public int updateUser(UserJpa user) {
        String sql = " update t_user set user_name =?,sex=?,note=? "
                + "where  id=?";
        return jdbcTemplate.update(sql, user.getUserName(),
                user.getSex().getId(), user.getNote(), user.getId());
    }

    @Override
    public int deleteUser(Long id) {
        String sql = "delete from t_user where id=?";
        return jdbcTemplate.update(sql, id);
    }
}
