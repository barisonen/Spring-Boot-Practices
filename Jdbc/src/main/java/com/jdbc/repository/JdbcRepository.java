package com.jdbc.repository;

import com.jdbc.entity.User;
import com.jdbc.util.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public List<User> process() {
        return jdbcTemplate.query("SELECT * FROM User", new UserRowMapper());
    }
}
