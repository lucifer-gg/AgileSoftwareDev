package com.example.AgileBackEnd.controller;

import com.example.AgileBackEnd.aop.logAspect.LogAnnotation;
import com.example.AgileBackEnd.entity.vo.Response;
import com.example.AgileBackEnd.entity.vo.TagVO;
import com.example.AgileBackEnd.service.TagService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagController {
    @Autowired
    private TagService tagService;

    @LogAnnotation("获取文章的标签")
    @GetMapping("/tags/getTagsByArticleId/{id}")
    public Response getTagsByArticleId(@PathVariable("id")Long id){
        List<TagVO> tagsByArticleId = tagService.findTagsByArticleId(id);
        return Response.success(tagsByArticleId);
    }

    @LogAnnotation("获取热门的标签")
    @GetMapping("/tags/hot")
    public Response hot(){
        int limit = 6;
        return tagService.findHostTags(limit);
    }

    @LogAnnotation("获取所有标签的简略信息")
    @GetMapping("/tags")
    public Response findAll(){
        return tagService.findAllTag();
    }

    @LogAnnotation("获取所有标签的详细信息")
    @GetMapping("/tags/detail")
    public Response findAllDetail(){
        return tagService.findAllTagDetail();
    }

    @LogAnnotation("获取某个标签的详细信息")
    @GetMapping("/tags/detail/{id}")
    public Response findDetailById(@PathVariable("id") Long id){
        return tagService.findArticleTagsById(id);
    }

}
