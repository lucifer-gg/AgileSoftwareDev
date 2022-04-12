package com.example.AgileBackEnd.entity.params;

import lombok.Data;

import java.util.Objects;

@Data
public class PageParams {
    private int page = 1;
    private int pageSize = 10;
    private Long categoryId;
    private Long tagId;
    private String year;
    private String month;

    public String getMonth(){
        if (this.month != null && this.month.length() == 1){
            return "0" + this.month;
        }
        return this.month;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageParams that = (PageParams) o;
        return page == that.page && pageSize == that.pageSize && Objects.equals(categoryId, that.categoryId) && Objects.equals(tagId, that.tagId) && Objects.equals(year, that.year) && Objects.equals(month, that.month);
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, pageSize, categoryId, tagId, year, month);
    }

    @Override
    public String toString() {
        return "PageParams{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", categoryId=" + categoryId +
                ", tagId=" + tagId +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}
