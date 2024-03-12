package com.project.icpcwiki.service;

import com.project.icpcwiki.mapper.EbookMapper;
import com.project.icpcwiki.pojo.Ebook;
import com.project.icpcwiki.pojo.EbookExample;
import com.project.icpcwiki.req.EbookReq;
import com.project.icpcwiki.resp.EbookResp;
import com.project.icpcwiki.util.CopyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {

    @Autowired
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req) {
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%"+req.getName()+"%");
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

//        for (Ebook ebook : ebookList) {
//            EbookResp ebookResp = new EbookResp();
//            BeanUtils.copyProperties(ebook, ebookResp);
//            EbookResp copy = CopyUtil.copy(ebook, EbookResp.class);
//            respList.add(copy);
//        }

        List<EbookResp> respList = CopyUtil.copyList(ebookList, EbookResp.class);
        return respList;
    }

}
