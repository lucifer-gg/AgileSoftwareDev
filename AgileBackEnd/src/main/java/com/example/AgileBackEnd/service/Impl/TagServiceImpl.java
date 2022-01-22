package com.example.AgileBackEnd.service.Impl;

import com.example.AgileBackEnd.dao.mapper.TagMapper;
import com.example.AgileBackEnd.entity.po.TagPO;
import com.example.AgileBackEnd.entity.vo.Response;
import com.example.AgileBackEnd.entity.vo.TagVO;
import com.example.AgileBackEnd.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;
    @Override
    public Response findHostTags(int limit) {
        return null;
    }

    @Override
    public Response findAllTag() {
        return null;
    }

    @Override
    public Response findAllTagDetail() {
        return null;
    }

    @Override
    public Response findArticleTagsById(Long id) {
        return null;
    }

    @Override
    public List<TagVO> findTagsByArticleId(Long articleId) {
        List<TagPO> tagsByArticleId = tagMapper.findTagsByArticleId(articleId);
        List<TagVO> res=new ArrayList<>();
        tagsByArticleId.forEach(o1->res.add(new TagVO(o1)));
        return res;
    }
}
