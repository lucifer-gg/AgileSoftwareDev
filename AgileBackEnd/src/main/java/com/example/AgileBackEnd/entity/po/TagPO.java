package com.example.AgileBackEnd.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ms_tag")
public class TagPO {
    private Long id;
    private String avatar;
    private String tagName;
}
