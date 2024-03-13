package com.project.icpcwiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.icpcwiki.mapper.EbookMapper;
import com.project.icpcwiki.pojo.Ebook;
import com.project.icpcwiki.pojo.EbookExample;
import com.project.icpcwiki.req.EbookQueryReq;
import com.project.icpcwiki.req.EbookSaveReq;
import com.project.icpcwiki.resp.EbookResp;
import com.project.icpcwiki.resp.PageResp;
import com.project.icpcwiki.util.CopyUtil;
import com.project.icpcwiki.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    private static final Logger LOG = LoggerFactory.getLogger(EbookService.class);

    @Autowired
    private EbookMapper ebookMapper;

    @Resource
    private SnowFlake snowFlake;


    public PageResp<EbookResp> list(EbookQueryReq req) {
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if (!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%" + req.getName() + "%");
        }

        PageHelper.startPage(req.getPage(), req.getSize());
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
        PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);
        LOG.info("总行数：{}",pageInfo.getTotal());
        LOG.info("总页数：{}",pageInfo.getPages());
        // for (Ebook ebook : ebookList) {
        // EbookResp ebookResp = new EbookResp();
        // BeanUtils.copyProperties(ebook, ebookResp);
        // EbookResp copy = CopyUtil.copy(ebook, EbookResp.class);
        // respList.add(copy);
        // }
        List<EbookResp> respList = CopyUtil.copyList(ebookList, EbookResp.class);
        PageResp<EbookResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(respList);
        return pageResp;
    }

    public void save(EbookSaveReq req) {
        Ebook ebook = CopyUtil.copy(req, Ebook.class);
        if (ObjectUtils.isEmpty(req.getId())) {
            ebook.setId(snowFlake.nextId());
            ebookMapper.insert(ebook);
        } else {
            ebookMapper.updateByPrimaryKey(ebook);
        }
    }


}
