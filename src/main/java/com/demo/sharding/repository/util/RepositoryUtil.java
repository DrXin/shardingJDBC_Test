package com.demo.sharding.repository.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class RepositoryUtil {

    @Autowired
    private DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void close(Connection con, PreparedStatement ps) throws SQLException {
        if(ps != null){
            ps.close();
        }
        if(con != null){
            con.close();
        }
    }

}
