package com.demo.sharding.repository;

import com.demo.sharding.po.TestDemo;
import com.demo.sharding.repository.util.RepositoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TestRepository {

    @Autowired
    RepositoryUtil util;
    //批量插入
    public void insertBatch(List<TestDemo> testDemos) throws SQLException {
        Connection connection = util.getConnection();
        connection.setAutoCommit(false);
        String sql = "insert into test (id,name,content,ch,f) values (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);


        for (int i=0; i < testDemos.size(); i++) {
            TestDemo demo = testDemos.get(i);
            preparedStatement.setLong(1,demo.getId());
            preparedStatement.setString(2,demo.getName());
            preparedStatement.setString(3,demo.getContent());
            preparedStatement.setString(4,demo.getCh());
            preparedStatement.setFloat(5,demo.getF());

            preparedStatement.addBatch();

            if (i%10000 == 0){
                preparedStatement.executeBatch();
                connection.commit();
                preparedStatement.clearBatch();
            }
        }

        preparedStatement.executeBatch();
        connection.commit();
        preparedStatement.clearBatch();
        util.close(connection,preparedStatement);
    }

    //插入一条数据
    public int insertDemo(TestDemo demo) throws SQLException {
        String sql = "insert into test (id,name,content,ch,f) values (?,?,?,?,?)";

        Connection connection = util.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setLong(1,demo.getId());
        preparedStatement.setString(2,demo.getName());
        preparedStatement.setString(3,demo.getContent());
        preparedStatement.setString(4,demo.getCh());
        preparedStatement.setFloat(5,demo.getF());

        int i = preparedStatement.executeUpdate();
        util.close(connection,preparedStatement);
        return i;
    }

    //根据ID查询demo
    public TestDemo selectDemoById(long id) throws SQLException {
        String sql = "select * from test where id=?";
        Connection connection = util.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1,id);

        ResultSet resultSet = preparedStatement.executeQuery();
        TestDemo demo = new TestDemo();
        while (resultSet.next()){
            demo.setId(id);
            demo.setName(resultSet.getString("name"));
            demo.setF(resultSet.getFloat("f"));
            demo.setContent(resultSet.getString("content"));
            demo.setCh(resultSet.getString("ch"));
        }

        return demo;
    }
}
