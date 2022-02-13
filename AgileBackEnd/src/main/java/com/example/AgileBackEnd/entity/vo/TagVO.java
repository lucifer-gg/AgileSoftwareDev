package com.example.AgileBackEnd.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.example.AgileBackEnd.entity.po.TagPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
