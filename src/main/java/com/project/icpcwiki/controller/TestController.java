package com.project.icpcwiki.controller;

import com.project.icpcwiki.pojo.Test;
import com.project.icpcwiki.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/hello")
    public String hello() {
        return "hello1";
    }

    @RequestMapping("/list")
    public List<Test> list() {
        return testService.list();
    }
}
