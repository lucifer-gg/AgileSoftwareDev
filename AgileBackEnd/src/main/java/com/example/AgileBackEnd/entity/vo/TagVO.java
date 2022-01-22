package com.example.AgileBackEnd.entity.vo;

import com.example.AgileBackEnd.entity.po.TagPO;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagVO {
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;
    private String tagName;
    private String avatar;
    public TagVO(TagPO tagPO){
        this.tagName=tagPO.getTagName();
        this.id=tagPO.getId();
        this.avatar=tagPO.getAvatar();
    }
}
