package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public User findByUsername(String username){

        return jdbcTemplate.queryForObject("select * from Users where first_name = ?", new Object[] {
                username
        },
                new BeanPropertyRowMapper<User>(User.class));
    }
}
