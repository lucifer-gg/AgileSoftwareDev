package com.example.AgileBackEnd.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.example.AgileBackEnd.entity.po.ArticleCategoryPO;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCategoryVO {
    @JSONField(serializeUsing = ToStringSerializer.class)
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