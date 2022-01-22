package com.example.AgileBackEnd.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ms_category")
public class ArticleCategoryPO {
    private Long id;
    private String avatar;
    private String categoryName;
    private String description;
}
