package com.example.AgileBackEnd.entity.vo;

import lombok.Data;

@Data
public class UserVO {

    private String nickname;

    private String avatar;

    //    @JsonSerialize(using = ToStringSerializer.class)
    private String id;
}