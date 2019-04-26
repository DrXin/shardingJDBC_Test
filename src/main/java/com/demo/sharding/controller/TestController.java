package com.demo.sharding.controller;

import com.demo.sharding.po.TestDemo;
import com.demo.sharding.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "insertBatch",method = RequestMethod.GET)
    @ResponseBody
    public String insertBatch(int num){
        testService.insertBatch(num);
        return "success";
    }

    @RequestMapping(value = "insertDemo",method = RequestMethod.GET)
    @ResponseBody
    public String insertDemo(){

        testService.insertDemo();

        return "success";
    }

    @RequestMapping(value = "findDemoById",method = RequestMethod.GET)
    @ResponseBody
    public TestDemo findDemoById(long id){
        TestDemo demo = testService.findDemoById(id);
        return demo;
    }

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "success";
    }
}
