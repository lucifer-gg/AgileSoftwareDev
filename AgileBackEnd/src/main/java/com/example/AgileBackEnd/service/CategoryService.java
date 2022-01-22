package com.example.AgileBackEnd.service;

import com.example.AgileBackEnd.entity.vo.Response;

public interface CategoryService {
    Response findAllCategory();
    Response findAllCategoryDetail();
    Response findCategoryDetailById(Long id);
}
