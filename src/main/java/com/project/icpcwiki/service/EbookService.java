package com.project.icpcwiki.service;

import com.project.icpcwiki.mapper.EbookMapper;
import com.project.icpcwiki.pojo.Ebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EbookService {

    @Autowired
    private EbookMapper ebookMapper;

    public List<Ebook> list() {
        return ebookMapper.selectByExample(null);
    }

}
