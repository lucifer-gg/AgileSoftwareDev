package com.example.AgileBackEnd.entity.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserVO {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String nickname;
    private String avatar;


}