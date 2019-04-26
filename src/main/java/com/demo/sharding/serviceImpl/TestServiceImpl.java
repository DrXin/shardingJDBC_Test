package com.demo.sharding.serviceImpl;

import com.demo.sharding.po.TestDemo;
import com.demo.sharding.repository.TestRepository;
import com.demo.sharding.service.TestService;
import com.demo.sharding.serviceImpl.util.RandomGenerator;
import io.shardingjdbc.core.keygen.DefaultKeyGenerator;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    private static DefaultKeyGenerator keyGenerator = new DefaultKeyGenerator();

//    private static Logger logger = Logger.getLogger(TestServiceImpl.class);

    @Transactional
    public void insertDemo(){
        try {
            int i = testRepository.insertDemo(getDemo());
//            logger.info("成功插入"+i+"条数据！");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public TestDemo findDemoById(long id) {
        try {
            return testRepository.selectDemoById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    public void insertBatch(int num) {

        List<TestDemo> demos = new ArrayList<>();
        for (int i=0; i < num ; i++){
            demos.add(getDemo());
        }
        try {
            testRepository.insertBatch(demos);
//            logger.info("成功插入"+num+"条记录！");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static TestDemo getDemo(){
        TestDemo demo = new TestDemo();
        long l = keyGenerator.generateKey().longValue();
        demo.setId(l);

        demo.setCh(RandomGenerator.getChar());
        demo.setContent(RandomGenerator.getContent());
        demo.setF(RandomGenerator.getFloat());
        demo.setName(RandomGenerator.getName());

        return demo;
    }
}
