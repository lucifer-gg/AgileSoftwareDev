package com.example.AgileBackEnd.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.example.AgileBackEnd.entity.po.TagPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagVO {
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    private String tagName;
    private String avatar;
    public TagVO(TagPO tagPO){
        this.tagName=tagPO.getTagName();
        this.id=tagPO.getId();
        this.avatar=tagPO.getAvatar();
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TagVO{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagVO tagVO = (TagVO) o;
        return Objects.equals(id, tagVO.id) && Objects.equals(tagName, tagVO.tagName) && Objects.equals(avatar, tagVO.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tagName, avatar);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
