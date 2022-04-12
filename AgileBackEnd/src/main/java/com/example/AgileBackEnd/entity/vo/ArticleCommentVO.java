package com.example.AgileBackEnd.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class ArticleCommentVO {
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    private UserVO author;
    private String content;
    private List<ArticleCommentVO> childrens;
    private String createDate;
    private Integer level;
    private UserVO toUser;

    @Override
    public String toString() {
        return "ArticleCommentVO{" +
                "id=" + id +
                ", author=" + author +
                ", content='" + content + '\'' +
                ", childrens=" + childrens +
                ", createDate='" + createDate + '\'' +
                ", level=" + level +
                ", toUser=" + toUser +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleCommentVO that = (ArticleCommentVO) o;
        return Objects.equals(id, that.id) && Objects.equals(author, that.author) && Objects.equals(content, that.content) && Objects.equals(childrens, that.childrens) && Objects.equals(createDate, that.createDate) && Objects.equals(level, that.level) && Objects.equals(toUser, that.toUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, content, childrens, createDate, level, toUser);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserVO getAuthor() {
        return author;
    }

    public void setAuthor(UserVO author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<ArticleCommentVO> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<ArticleCommentVO> childrens) {
        this.childrens = childrens;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public UserVO getToUser() {
        return toUser;
    }

    public void setToUser(UserVO toUser) {
        this.toUser = toUser;
    }
}