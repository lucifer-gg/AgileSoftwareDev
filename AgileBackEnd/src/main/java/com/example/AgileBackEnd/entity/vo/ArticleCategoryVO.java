package com.example.AgileBackEnd.entity.vo;

import com.example.AgileBackEnd.entity.po.ArticleCategoryPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCategoryVO {
    @JsonSerialize(using=ToStringSerializer.class)
    private Long id;
    private String avatar;
    private String categoryName;
    private String description;

    public ArticleCategoryVO(ArticleCategoryPO articleCategoryPO){
        this.id=articleCategoryPO.getId();
        this.avatar=articleCategoryPO.getAvatar();
        this.categoryName=articleCategoryPO.getCategoryName();
        this.description=articleCategoryPO.getDescription();
    }
}