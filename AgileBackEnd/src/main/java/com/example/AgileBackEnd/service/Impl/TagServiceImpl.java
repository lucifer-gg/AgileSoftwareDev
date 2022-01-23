package com.example.AgileBackEnd.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.AgileBackEnd.dao.mapper.TagMapper;
import com.example.AgileBackEnd.entity.po.TagPO;
import com.example.AgileBackEnd.entity.vo.Response;
import com.example.AgileBackEnd.entity.vo.TagVO;
import com.example.AgileBackEnd.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;
    @Override
    public Response findHostTags(int limit) {
        List<Long> tagIds = tagMapper.findHotsTagIds(limit);
        if (CollectionUtils.isEmpty(tagIds)){
            return Response.success(Collections.emptyList());
        }
        List<TagPO> tagPOList = tagMapper.findTagByTagIds(tagIds);
        return Response.success(tagPOList);
    }

    @Override
    public Response findAllTag() {
        List<TagPO> tagPOList = tagMapper.selectList(new LambdaQueryWrapper<TagPO>().select(TagPO::getId, TagPO::getTagName));
        return Response.success(createTagVOFromPO(tagPOList));
    }

    @Override
    public Response findAllTagDetail() {
        List<TagPO> tagPOList = tagMapper.selectList(new LambdaQueryWrapper<TagPO>());
        return Response.success(createTagVOFromPO(tagPOList));
    }

    @Override
    public Response findArticleTagsById(Long id) {
        TagPO tagPO = tagMapper.selectById(id);
        return Response.success(createSingle(tagPO));
    }

    @Override
    public List<TagVO> findTagsByArticleId(Long articleId) {
        List<TagPO> tagsByArticleId = tagMapper.findTagsByArticleId(articleId);
        List<TagVO> res=new ArrayList<>();
        tagsByArticleId.forEach(o1->res.add(new TagVO(o1)));
        return res;
    }

    private List<TagVO> createTagVOFromPO(List<TagPO> pos){
        List<TagVO> tagVOS=new ArrayList<>();
        pos.forEach(o1->tagVOS.add(createSingle(o1)));
        return tagVOS;
    }
    private TagVO createSingle(TagPO tagPO){
        TagVO tagVO=new TagVO();
        tagVO.setId(tagPO.getId());
        tagVO.setTagName(tagPO.getTagName());
        tagVO.setAvatar(tagPO.getAvatar());
        return tagVO;
    }
}
