package com.substring.database.dao;

import com.substring.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserDao {

    //using field injection for dependency
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int saveUser(User user){
        //we want to save user
        String query = "insert into users values(?,?,?,?,?,?)";
        int rowsEffected = jdbcTemplate.update(
        query,
                user.getUserId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getCity(),
                user.getSalary()


        );
        System.out.println("User added: " + rowsEffected );
        return rowsEffected;
    }

    public User get(int userid) {
        String sql = "SELECT * FROM user WHERE userId = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            User user = new User();
            user.setUserId(rs.getInt("userId"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setCity(rs.getString("city"));
            user.setSalary((rs.getInt("salary")));
            return user;
        });
    }
}
