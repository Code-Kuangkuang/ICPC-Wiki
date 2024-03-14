package com.project.icpcwiki.controller;

import com.project.icpcwiki.req.CategoryQueryReq;
import com.project.icpcwiki.req.CategorySaveReq;
import com.project.icpcwiki.resp.CommonResp;
import com.project.icpcwiki.resp.CategoryResp;
import com.project.icpcwiki.resp.PageResp;
import com.project.icpcwiki.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public CommonResp<PageResp<CategoryResp>> list(@Valid CategoryQueryReq req) {
        CommonResp<PageResp<CategoryResp>> resp = new CommonResp<>();
        PageResp<CategoryResp> list = categoryService.list(req);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody CategorySaveReq req) {
        CommonResp resp = new CommonResp<>();
        categoryService.save(req);
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        categoryService.delete(id);
        return resp;
    }

}
