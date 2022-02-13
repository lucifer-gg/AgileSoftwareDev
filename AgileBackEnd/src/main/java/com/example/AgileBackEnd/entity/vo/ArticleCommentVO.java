package com.example.AgileBackEnd.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.Data;

import java.util.List;

@Data
public class ArticleCommentVO {
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    private UserVO author;
    private String content;
    private List<ArticleCommentVO> childrens;
    private String createDate;
    private Integer level;
    private UserVO toUser;
}