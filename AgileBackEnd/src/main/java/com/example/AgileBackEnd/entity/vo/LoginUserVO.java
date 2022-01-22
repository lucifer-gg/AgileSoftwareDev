package com.example.AgileBackEnd.entity.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LoginUserVO {
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    private String account;

    private String nickname;

    private String avatar;
}
