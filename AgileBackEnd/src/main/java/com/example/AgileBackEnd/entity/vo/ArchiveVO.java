package com.example.AgileBackEnd.entity.vo;

import lombok.Data;

import java.util.Objects;

@Data
public class ArchiveVO {
    private Integer year;
    private Integer month;
    private Long count;

    @Override
    public String toString() {
        return "ArchiveVO{" +
                "year=" + year +
                ", month=" + month +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArchiveVO archiveVO = (ArchiveVO) o;
        return Objects.equals(year, archiveVO.year) && Objects.equals(month, archiveVO.month) && Objects.equals(count, archiveVO.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, count);
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
