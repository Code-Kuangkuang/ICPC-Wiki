package com.project.icpcwiki.controller;

import com.project.icpcwiki.req.EbookQueryReq;
import com.project.icpcwiki.req.EbookReq;
import com.project.icpcwiki.req.EbookSaveReq;
import com.project.icpcwiki.resp.CommonResp;
import com.project.icpcwiki.resp.EbookResp;
import com.project.icpcwiki.resp.PageResp;
import com.project.icpcwiki.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Autowired
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp<PageResp<EbookResp>> list(EbookQueryReq req) {
        CommonResp<PageResp<EbookResp>> resp = new CommonResp<>();
        PageResp<EbookResp> list = ebookService.list(req);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@RequestBody EbookSaveReq req) {
        CommonResp resp = new CommonResp<>();
        ebookService.save(req);
        return resp;
    }

}
