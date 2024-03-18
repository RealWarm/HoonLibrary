package com.group.libraryapp.repository.user;


import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveUser(String name, int age){
        String sql = "INSERT INTO USER (NAME, AGE) VALUES(?, ?)";
        // 데이터의 변경을 의미한다(insert, update, delete 사용가능)
        jdbcTemplate.update(sql, name, age);
    }

    public List<UserResponse> getUsers(){
        String sql = "SELECT * FROM USER";
        List<UserResponse> aa = jdbcTemplate.query(sql, new RowMapper<UserResponse>(){
            @Override
            public UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                long id = rs.getLong("id");
                String name =rs.getString("name");
                int age = rs.getInt("age");
                return new UserResponse(id, name, age);
            }
        });
        return aa;
    }

    // request에 있는 모든 필드를 쓰는게 아니다보니, 특정 필드만 내려주는걸 선호함
    public boolean isUserNotExistById(long id){
        String readSql="SELECT * FROM user WHERE id=?";
        return jdbcTemplate.query(readSql, (rs, rowNum)-> 0, id).isEmpty();
    }

    public void updateUserName(String name, long id){
        String sql = "UPDATE USER SET name=? WHERE id=?";
        jdbcTemplate.update(sql, name, id);
    }

    public boolean isUserNotExistByName(String name){
        String readSql="SELECT * FROM user WHERE name=?";
        boolean isUserNotExist=jdbcTemplate.query(readSql, (rs, rowNum)-> 0, name).isEmpty();
        return isUserNotExist;
    }

    public void deleteUser(String name){
        if(isUserNotExistByName(name)){
            throw new IllegalArgumentException();
        }
        String sql = "DELETE FROM USER WHERE name=?";
        jdbcTemplate.update(sql, name);
    }
}
