package com.example.AgileBackEnd.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.AgileBackEnd.entity.po.ArticlePO;
import com.example.AgileBackEnd.entity.vo.ArchiveVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper extends BaseMapper<ArticlePO> {
    List<ArchiveVO> listArchives();
}
