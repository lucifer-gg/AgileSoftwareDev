package com.example.AgileBackEnd.entity.params;

import lombok.Data;

import java.util.Objects;

@Data
public class LoginParam {
    private String account;
    private String password;
    private String nickname;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginParam that = (LoginParam) o;
        return Objects.equals(account, that.account) && Objects.equals(password, that.password) && Objects.equals(nickname, that.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, password, nickname);
    }

    @Override
    public String toString() {
        return "LoginParam{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}