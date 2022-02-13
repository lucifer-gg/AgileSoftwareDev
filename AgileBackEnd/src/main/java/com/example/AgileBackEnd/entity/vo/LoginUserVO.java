package com.example.AgileBackEnd.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;

import lombok.Data;

@Data
public class LoginUserVO {
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;

    private String account;

    private String nickname;

    private String avatar;
}
