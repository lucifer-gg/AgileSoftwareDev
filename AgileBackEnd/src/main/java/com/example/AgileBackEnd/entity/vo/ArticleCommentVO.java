package com.example.AgileBackEnd.entity.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class ArticleCommentVO {
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;
    private UserVO author;
    private String content;
    private List<ArticleCommentVO> childrens;
    private String createDate;
    private Integer level;
    private UserVO toUser;
}