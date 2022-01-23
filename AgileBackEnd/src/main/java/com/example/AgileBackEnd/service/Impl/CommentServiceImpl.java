package com.example.AgileBackEnd.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.AgileBackEnd.dao.mapper.ArticleCommentMapper;
import com.example.AgileBackEnd.entity.params.ArticleCommentParam;
import com.example.AgileBackEnd.entity.po.ArticleCommentPO;
import com.example.AgileBackEnd.entity.po.UserPO;
import com.example.AgileBackEnd.entity.vo.ArticleCommentVO;
import com.example.AgileBackEnd.entity.vo.Response;
import com.example.AgileBackEnd.entity.vo.UserVO;
import com.example.AgileBackEnd.service.CommentService;
import com.example.AgileBackEnd.service.UserService;
import com.example.AgileBackEnd.utils.UserThreadLocal;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private ArticleCommentMapper articleCommentMapper;
    @Autowired
    private UserService userService;
    @Override
    public Response findCommentsByArticleId(Long articleId) {
        LambdaQueryWrapper<ArticleCommentPO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ArticleCommentPO::getArticleId,articleId);
        wrapper.eq(ArticleCommentPO::getLevel,1);
        List<ArticleCommentPO> articleCommentPOS = articleCommentMapper.selectList(wrapper);
        List<ArticleCommentVO> commentVoList = createVOFromPO(articleCommentPOS);
        return Response.success(commentVoList);
    }

    @Override
    public Response addComment(ArticleCommentParam commentParam) {
        UserPO userPO = UserThreadLocal.get();
        ArticleCommentPO articleCommentPO = new ArticleCommentPO();
        articleCommentPO.setArticleId(commentParam.getArticleId());
        articleCommentPO.setAuthorId(userPO.getId());
        articleCommentPO.setContent(commentParam.getContent());
        articleCommentPO.setCreateDate(System.currentTimeMillis());
        Long parent = commentParam.getParent();
        if (parent == null || parent == 0) {
            articleCommentPO.setLevel(1);
        }else{
            articleCommentPO.setLevel(2);
        }
        articleCommentPO.setParentId(parent == null ? 0 : parent);
        Long toUserId = commentParam.getToUserId();
        articleCommentPO.setToUid(toUserId == null ? 0 : toUserId);
        this.articleCommentMapper.insert(articleCommentPO);
        return Response.success(null);
    }

    private List<ArticleCommentVO> createVOFromPO(List<ArticleCommentPO> pos){
        List<ArticleCommentVO> res=new ArrayList<>();
        pos.forEach(o1->res.add(createSingle(o1)));
        return res;
    }

    private ArticleCommentVO createSingle(ArticleCommentPO po){
        ArticleCommentVO vo=new ArticleCommentVO();
        vo.setId(po.getId());
        vo.setContent(po.getContent());
        vo.setAuthor(userService.findUserVoById(po.getAuthorId()));
        vo.setLevel(po.getLevel());
        vo.setCreateDate(new DateTime(po.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        Integer level = po.getLevel();
        if (level == 1){
            Long id = po.getId();
            List<ArticleCommentVO> commentVoList = findChildCommentsByParentId(id);
            vo.setChildrens(commentVoList);
        }
        if (level > 1){
            Long toUid = po.getToUid();
            UserVO userVOById = userService.findUserVoById(toUid);
            vo.setToUser(userVOById);
        }
        return vo;
    }

    private List<ArticleCommentVO> findChildCommentsByParentId(Long id){
        LambdaQueryWrapper<ArticleCommentPO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ArticleCommentPO::getParentId,id);
        wrapper.eq(ArticleCommentPO::getLevel,2);
        List<ArticleCommentPO> articleCommentPOS = articleCommentMapper.selectList(wrapper);
        List<ArticleCommentVO> commentVoList = createVOFromPO(articleCommentPOS);
        return commentVoList;
    }
}
