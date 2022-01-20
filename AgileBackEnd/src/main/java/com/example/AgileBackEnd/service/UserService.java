package com.example.AgileBackEnd.service;

import com.example.AgileBackEnd.entity.params.LoginParam;
import com.example.AgileBackEnd.entity.po.UserPO;
import com.example.AgileBackEnd.entity.vo.Response;
import com.example.AgileBackEnd.entity.vo.UserVO;

public interface UserService {
    Response register(LoginParam loginParam);
    Response login(LoginParam loginParam);
    Response logout(String token);
    Response findUserByToken(String token);
    UserVO findUserVoById(Long id);
    UserPO findUserById(Long id);
    UserPO findUser(String account, String password);
    UserPO findUserByAccount(String account);
    void save(UserPO userPO);
    UserPO checkToken(String token);

}
