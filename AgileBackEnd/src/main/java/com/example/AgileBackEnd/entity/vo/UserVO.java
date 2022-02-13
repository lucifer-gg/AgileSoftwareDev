package com.example.AgileBackEnd.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;

import lombok.Data;


@Data
public class UserVO {
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    private String nickname;
    private String avatar;


}