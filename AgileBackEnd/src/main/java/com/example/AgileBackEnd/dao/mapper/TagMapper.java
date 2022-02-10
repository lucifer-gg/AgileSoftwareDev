package com.example.AgileBackEnd.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.AgileBackEnd.entity.po.TagPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagMapper extends BaseMapper<TagPO> {
    List<TagPO>  findTagsByArticleId(Long articleId);
    List<Long> findHotsTagIds(int limit);
    List<TagPO> findTagByTagIds(@Param("tagIds") List<Long> tagIds);
}
