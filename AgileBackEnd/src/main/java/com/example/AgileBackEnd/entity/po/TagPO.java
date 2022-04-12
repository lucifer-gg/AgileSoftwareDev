package com.example.AgileBackEnd.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Objects;

@Data
@TableName("ms_tag")
public class TagPO {
    private Long id;
    private String avatar;
    private String tagName;

    @Override
    public String toString() {
        return "TagPO{" +
                "id=" + id +
                ", avatar='" + avatar + '\'' +
                ", tagName='" + tagName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagPO tagPO = (TagPO) o;
        return Objects.equals(id, tagPO.id) && Objects.equals(avatar, tagPO.avatar) && Objects.equals(tagName, tagPO.tagName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, avatar, tagName);
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

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}

