package com.example.AgileBackEnd.service;

import com.example.AgileBackEnd.entity.vo.Response;
import com.example.AgileBackEnd.entity.vo.TagVO;

import java.util.List;

public interface TagService {
    Response findHostTags(int limit);
    Response findAllTag();
    Response findAllTagDetail();
    Response findArticleTagsById(Long id);
    List<TagVO> findTagsByArticleId(Long articleId);
}
