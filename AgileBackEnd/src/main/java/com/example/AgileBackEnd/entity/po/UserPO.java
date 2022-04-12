package com.example.AgileBackEnd.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Objects;

@Data
@TableName("ms_sys_user")
public class UserPO {

    private Long id;

    private String account;

    private Integer admin;

    private String avatar;

    private Long createDate;

    private Integer deleted;

    private String email;

    private Long lastLogin;

    private String mobilePhoneNumber;

    private String nickname;

    private String password;

    private String salt;

    private String status;

    @Override
    public String toString() {
        return "UserPO{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", admin=" + admin +
                ", avatar='" + avatar + '\'' +
                ", createDate=" + createDate +
                ", deleted=" + deleted +
                ", email='" + email + '\'' +
                ", lastLogin=" + lastLogin +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPO userPO = (UserPO) o;
        return Objects.equals(id, userPO.id) && Objects.equals(account, userPO.account) && Objects.equals(admin, userPO.admin) && Objects.equals(avatar, userPO.avatar) && Objects.equals(createDate, userPO.createDate) && Objects.equals(deleted, userPO.deleted) && Objects.equals(email, userPO.email) && Objects.equals(lastLogin, userPO.lastLogin) && Objects.equals(mobilePhoneNumber, userPO.mobilePhoneNumber) && Objects.equals(nickname, userPO.nickname) && Objects.equals(password, userPO.password) && Objects.equals(salt, userPO.salt) && Objects.equals(status, userPO.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, admin, avatar, createDate, deleted, email, lastLogin, mobilePhoneNumber, nickname, password, salt, status);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Long lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}