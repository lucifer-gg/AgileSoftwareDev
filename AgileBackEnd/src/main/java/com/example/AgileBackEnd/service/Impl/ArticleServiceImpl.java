package com.example.AgileBackEnd.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.AgileBackEnd.dao.mapper.ArticleBodyMapper;
import com.example.AgileBackEnd.dao.mapper.ArticleCategoryMapper;
import com.example.AgileBackEnd.dao.mapper.ArticleMapper;
import com.example.AgileBackEnd.dao.mapper.ArticleToTagMapper;
import com.example.AgileBackEnd.entity.params.ArticleParam;
import com.example.AgileBackEnd.entity.params.PageParams;
import com.example.AgileBackEnd.entity.po.ArticleBodyPO;
import com.example.AgileBackEnd.entity.po.ArticlePO;
import com.example.AgileBackEnd.entity.po.ArticleToTagPO;
import com.example.AgileBackEnd.entity.po.UserPO;
import com.example.AgileBackEnd.entity.vo.*;
import com.example.AgileBackEnd.service.ArticleService;
import com.example.AgileBackEnd.service.TagService;
import com.example.AgileBackEnd.service.UserService;
import com.example.AgileBackEnd.utils.UserThreadLocal;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleToTagMapper articleToTagMapper;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleCategoryMapper categoryMapper;
    @Autowired
    private ArticleBodyMapper articleBodyMapper;
    @Autowired
    private TagService tagService;

    @Override
    public Response listArticle(PageParams pageParams) {
        Page<ArticlePO> page = new Page<>(pageParams.getPage(), pageParams.getPageSize());
        LambdaQueryWrapper<ArticlePO> articleLambdaQueryWrapper = new LambdaQueryWrapper<ArticlePO>();
        if (pageParams.getCategoryId() != null){
            articleLambdaQueryWrapper.eq(ArticlePO::getCategoryId,pageParams.getCategoryId());
        }
        ArrayList<Long> articleIdList = new ArrayList<>();
        if (pageParams.getTagId() != null){
            LambdaQueryWrapper<ArticleToTagPO> articleTagLambdaQueryWrapper = new LambdaQueryWrapper<>();
            articleTagLambdaQueryWrapper.eq(ArticleToTagPO::getTagId,pageParams.getTagId());
            List<ArticleToTagPO> articleTags = articleToTagMapper.selectList(articleTagLambdaQueryWrapper);
            for (ArticleToTagPO articleTag : articleTags) {
                articleIdList.add(articleTag.getArticleId());
            }
            if (articleIdList.size() > 0){
                articleLambdaQueryWrapper.in(ArticlePO::getId,articleIdList);
            }

        }
        articleLambdaQueryWrapper.orderByDesc(ArticlePO::getWeight, ArticlePO::getCreateDate);
        Page<ArticlePO> articlePage = articleMapper.selectPage(page, articleLambdaQueryWrapper);
        List<ArticlePO> records = articlePage.getRecords();
        List<ArticleVO> articleVoList = createArtilceVoFromPo(records);
        return Response.success(articleVoList);
    }

    private List<ArticleVO> createArtilceVoFromPo(List<ArticlePO> poList){
        List<ArticleVO> voList=new ArrayList<>();
        poList.forEach(o1->voList.add(copySingleFromPoToVo(o1)));
        return voList;
    }
    private ArticleVO copySingleFromPoToVo(ArticlePO articlePO){
        ArticleVO articleVO=new ArticleVO();
        articleVO.setId(articlePO.getId());
        articleVO.setCreateDate(new DateTime(articlePO.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        articleVO.setTitle(articlePO.getTitle());
        articleVO.setSummary(articlePO.getSummary());
        articleVO.setCommentCounts(articlePO.getCommentCounts());
        articleVO.setViewCounts(articlePO.getViewCounts());
        articleVO.setWeight(articlePO.getWeight());
        articleVO.setAuthor(userService.findUserById(articlePO.getAuthorId()).getNickname());
        articleVO.setArticleCategoryVo(new ArticleCategoryVO(categoryMapper.selectById(articlePO.getCategoryId())));
        articleVO.setBody(new ArticleBodyVO(articleBodyMapper.selectById(articlePO.getBodyId())));
        articleVO.setTags(tagService.findTagsByArticleId(articlePO.getId()));
        return articleVO;
    }


    @Override
    public Response hotArticle(int limit) {
        LambdaQueryWrapper<ArticlePO> last = new LambdaQueryWrapper<ArticlePO>().orderByDesc(ArticlePO::getViewCounts).last("limit " + limit);
        List<ArticlePO> articlePOS = articleMapper.selectList(last);
        return Response.success(createArtilceVoFromPo(articlePOS));
    }

    @Override
    public Response newArticles(int limit) {
        LambdaQueryWrapper<ArticlePO> last = new LambdaQueryWrapper<ArticlePO>().orderByDesc(ArticlePO::getCreateDate).last("limit " + limit);
        List<ArticlePO> articlePOS = articleMapper.selectList(last);
        return Response.success(createArtilceVoFromPo(articlePOS));
    }

    @Override
    public Response listArchives() {
        return null;
    }

    @Override
    public Response findArticleById(Long articleId) {
        //每次进入这个方法更新观看数，更新的过程可以使用异步
        ArticlePO articlePO = articleMapper.selectById(articleId);
        ArticleVO articleVo = copySingleFromPoToVo(articlePO);
        updateArticleViewCount(articleMapper, articlePO);
        return Response.success(articleVo);
    }
    @Async("taskExecutor")
    public void updateArticleViewCount(ArticleMapper articleMapper, ArticlePO articlePO) {
        int viewCounts = articlePO.getViewCounts();
        ArticlePO articlePOUpdate = new ArticlePO();
        articlePOUpdate.setViewCounts(viewCounts + 1);
        articleMapper.update(articlePOUpdate,new LambdaUpdateWrapper<ArticlePO>().eq(ArticlePO::getId, articlePO.getId()));
    }

    @Override
    public Response publishArticle(ArticleParam articleParam){
        UserPO userPO = UserThreadLocal.get();
        ArticlePO articlePO = new ArticlePO();
        articlePO.setAuthorId(userPO.getId());
        articlePO.setWeight(ArticlePO.Article_Common);
        articlePO.setViewCounts(0);
        articlePO.setTitle(articleParam.getTitle());
        articlePO.setSummary(articleParam.getSummary());
        articlePO.setCommentCounts(0);
        articlePO.setCreateDate(System.currentTimeMillis());
        articlePO.setCategoryId(articleParam.getCategory().getId());
        this.articleMapper.insert(articlePO);
        List<TagVO> tagPOS = articleParam.getTags();
        if (tagPOS != null){
            for (TagVO tag : tagPOS) {
                Long articleId = articlePO.getId();
                ArticleToTagPO articleToTagPO = new ArticleToTagPO();
                articleToTagPO.setTagId(tag.getId());
                articleToTagPO.setArticleId(articleId);
                articleToTagMapper.insert(articleToTagPO);
            }
        }

        ArticleBodyPO articleBodyPO = new ArticleBodyPO();
        articleBodyPO.setArticleId(articlePO.getId());
        articleBodyPO.setContent(articleParam.getBody().getContent());
        articleBodyPO.setContentHtml(articleParam.getBody().getContentHtml());
        articleBodyMapper.insert(articleBodyPO);
        articlePO.setBodyId(articleBodyPO.getId());
        articleMapper.updateById(articlePO);
        HashMap<String, String> map = new HashMap<>();
        map.put("id", articlePO.getId().toString());
        return Response.success(map);
    }
}
