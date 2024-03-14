package com.project.icpcwiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.icpcwiki.mapper.CategoryMapper;
import com.project.icpcwiki.pojo.Category;
import com.project.icpcwiki.pojo.CategoryExample;
import com.project.icpcwiki.req.CategoryQueryReq;
import com.project.icpcwiki.req.CategorySaveReq;
import com.project.icpcwiki.resp.CategoryResp;
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
public class CategoryService {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    private CategoryMapper categoryMapper;

    @Resource
    private SnowFlake snowFlake;


    public PageResp<CategoryResp> list(CategoryQueryReq req) {
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        if (!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%" + req.getName() + "%");
        }

        PageHelper.startPage(req.getPage(), req.getSize());
        List<Category> categoryList = categoryMapper.selectByExample(categoryExample);
        PageInfo<Category> pageInfo = new PageInfo<>(categoryList);
        LOG.info("总行数：{}",pageInfo.getTotal());
        LOG.info("总页数：{}",pageInfo.getPages());
        // for (Category category : categoryList) {
        // CategoryResp categoryResp = new CategoryResp();
        // BeanUtils.copyProperties(category, categoryResp);
        // CategoryResp copy = CopyUtil.copy(category, CategoryResp.class);
        // respList.add(copy);
        // }
        List<CategoryResp> respList = CopyUtil.copyList(categoryList, CategoryResp.class);
        PageResp<CategoryResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(respList);
        return pageResp;
    }

    public void save(CategorySaveReq req) {
        Category category = CopyUtil.copy(req, Category.class);
        if (ObjectUtils.isEmpty(req.getId())) {
            category.setId(snowFlake.nextId());
            categoryMapper.insert(category);
        } else {
            categoryMapper.updateByPrimaryKey(category);
        }
    }

    public void delete(Long id) {
        categoryMapper.deleteByPrimaryKey(id);
    }


}
