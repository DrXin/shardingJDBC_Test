package com.demo.sharding.service;

import com.demo.sharding.po.TestDemo;

public interface TestService {
    void insertBatch(int num);
    void insertDemo();
    TestDemo findDemoById(long id);
}
