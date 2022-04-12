package com.example.AgileBackEnd.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.example.AgileBackEnd.entity.po.ArticleCategoryPO;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "ArticleCategoryVO{" +
                "id=" + id +
                ", avatar='" + avatar + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleCategoryVO that = (ArticleCategoryVO) o;
        return Objects.equals(id, that.id) && Objects.equals(avatar, that.avatar) && Objects.equals(categoryName, that.categoryName) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, avatar, categoryName, description);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}