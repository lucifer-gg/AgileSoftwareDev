package com.example.AgileBackEnd.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.AgileBackEnd.dao.mapper.ArticleCategoryMapper;
import com.example.AgileBackEnd.entity.po.ArticleCategoryPO;
import com.example.AgileBackEnd.entity.vo.ArticleCategoryVO;
import com.example.AgileBackEnd.entity.vo.Response;
import com.example.AgileBackEnd.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ArticleCategoryMapper articleCategoryMapper;
    @Override
    public Response findAllCategory() {
        List<ArticleCategoryPO> categories = articleCategoryMapper.selectList(new LambdaQueryWrapper<ArticleCategoryPO>().select(ArticleCategoryPO::getId, ArticleCategoryPO::getCategoryName));
        return Response.success(createVOFromPO(categories));
    }

    @Override
    public Response findAllCategoryDetail() {
        List<ArticleCategoryPO> categories = articleCategoryMapper.selectList(new LambdaQueryWrapper<ArticleCategoryPO>());
        return Response.success(createVOFromPO(categories));
    }

    @Override
    public Response findCategoryDetailById(Long id) {
        ArticleCategoryPO articleCategoryPO = articleCategoryMapper.selectById(id);
        return Response.success(createSingle(articleCategoryPO));
    }

    private List<ArticleCategoryVO> createVOFromPO(List<ArticleCategoryPO> pos){
        List<ArticleCategoryVO> res=new ArrayList<>();
        pos.forEach(o1->res.add(createSingle(o1)));
        return res;
    }

    private ArticleCategoryVO createSingle(ArticleCategoryPO po){
        ArticleCategoryVO articleCategoryVO=new ArticleCategoryVO();
        articleCategoryVO.setCategoryName(po.getCategoryName());
        articleCategoryVO.setId(po.getId());
        articleCategoryVO.setAvatar(po.getAvatar());
        articleCategoryVO.setDescription(po.getDescription());
        return articleCategoryVO;
    }
}
