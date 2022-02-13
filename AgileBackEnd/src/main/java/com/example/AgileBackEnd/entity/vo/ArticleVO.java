package com.example.AgileBackEnd.entity.vo;



import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.Data;

import java.util.List;

@Data
public class ArticleVO {
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    private String title;
    private String summary;
    private Integer commentCounts;
    private Integer viewCounts;
    private Integer weight;
    private String createDate;
    private String author;
    private ArticleBodyVO body;
    private List<TagVO> tags;
    private ArticleCategoryVO articleCategoryVo;

}