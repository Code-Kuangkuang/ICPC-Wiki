package com.project.icpcwiki.service;

import com.project.icpcwiki.mapper.TestMapper;
import com.project.icpcwiki.pojo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public List<Test> list() {
        return testMapper.list();
    }

}
