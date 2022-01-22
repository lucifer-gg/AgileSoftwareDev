package com.example.AgileBackEnd.controller;

import com.example.AgileBackEnd.entity.vo.Response;
import com.example.AgileBackEnd.entity.vo.TagVO;
import com.example.AgileBackEnd.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;
    @GetMapping("/getTagsByArticleId/{id}")
    public Response getTagsByArticleId(@PathVariable("id")Long id){
        List<TagVO> tagsByArticleId = tagService.findTagsByArticleId(id);
        return Response.success(tagsByArticleId);


    }
}
