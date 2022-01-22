package com.example.AgileBackEnd.service.Impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.AgileBackEnd.dao.mapper.UserMapper;
import com.example.AgileBackEnd.entity.params.LoginParam;
import com.example.AgileBackEnd.entity.po.UserPO;
import com.example.AgileBackEnd.entity.vo.LoginUserVO;
import com.example.AgileBackEnd.entity.vo.Response;
import com.example.AgileBackEnd.entity.vo.Status;
import com.example.AgileBackEnd.entity.vo.UserVO;
import com.example.AgileBackEnd.service.UserService;
import com.example.AgileBackEnd.utils.JWTUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;


import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private UserMapper userMapper;

    private static final String slat = "lucifer@cmw";


    @Override
    public Response register(LoginParam loginParam) {
        String account = loginParam.getAccount();
        String nickname = loginParam.getNickname();
        String password = loginParam.getPassword();
        if (StringUtils.isBlank(account) || StringUtils.isBlank(nickname) || StringUtils.isBlank(password)){
            return Response.fail(Status.PARAMS_ERROR.getCode(), Status.PARAMS_ERROR.getMsg());
        }
        UserPO userPO = this.findUserByAccount(account);
        if (userPO != null){
            return Response.fail(Status.ACCOUNT_EXIST.getCode(),"账户已经被注册了");
        }

        userPO = new UserPO();
        userPO.setNickname(nickname);
        userPO.setAccount(account);
        userPO.setPassword(DigestUtils.md5Hex(password + slat));
        userPO.setCreateDate(System.currentTimeMillis());
        userPO.setLastLogin(System.currentTimeMillis());
        //要改
        userPO.setAvatar("/static/images/default.jpeg");
        userPO.setAdmin(1);
        userPO.setDeleted(0);
        userPO.setSalt("");
        userPO.setSalt("");
        userPO.setEmail("");
        this.save(userPO);
        System.out.println("用户名ID为" + userPO.getId());
        String token = JWTUtils.createToken(userPO.getId());
        redisTemplate.opsForValue().set("TOKEN_" + token, JSON.toJSONString(userPO),1,TimeUnit.DAYS);
        return Response.success(token);
    }

    @Override
    public Response login(LoginParam loginParam) {
        String account = loginParam.getAccount();
        String password = loginParam.getPassword();
        if (org.apache.commons.lang3.StringUtils.isBlank(account) || org.apache.commons.lang3.StringUtils.isBlank(password)){
            return Response.fail(Status.PARAMS_ERROR.getCode(), Status.PARAMS_ERROR.getMsg());
        }
        password = DigestUtils.md5Hex(password + slat);
        UserPO userPO = this.findUser(account,password);
        if (userPO == null){
            return Response.fail(Status.ACCOUNT_PWD_NOT_EXIST.getCode(), Status.ACCOUNT_PWD_NOT_EXIST.getMsg());
        }
        String token = JWTUtils.createToken(userPO.getId());

        redisTemplate.opsForValue().set("TOKEN_" + token, JSON.toJSONString(userPO),1, TimeUnit.DAYS);

        return Response.success(token);
    }

    @Override
    public Response logout(String token) {
        redisTemplate.delete("TOKEN_" + token);
        return Response.success(null);
    }

    @Override
    public Response findUserByToken(String token) {
        UserPO userPO = this.checkToken(token);
        if (userPO == null){
            Response.fail(Status.TOKEN_ERROR.getCode(), Status.TOKEN_ERROR.getMsg());
        }
        LoginUserVO loginUserVo = new LoginUserVO();
        loginUserVo.setId(userPO.getId());
        loginUserVo.setNickname(userPO.getNickname());
        loginUserVo.setAvatar(userPO.getAvatar());
        loginUserVo.setAccount(userPO.getAccount());

        return Response.success(loginUserVo);

    }

    @Override
    public UserVO findUserVoById(Long id) {
        UserPO userPO = userMapper.selectById(id);
        if (userPO == null){
            userPO = new UserPO();
            userPO.setId(1L);
            userPO.setAvatar("/static/images/default.jpeg");
            userPO.setNickname("落樱");
        }
        UserVO userVo = new UserVO();
        BeanUtils.copyProperties(userPO,userVo);
        userVo.setId(userPO.getId());
        return userVo;
    }

    @Override
    public UserPO findUserById(Long id) {
        UserPO userPO = userMapper.selectById(id);
        if (userPO == null){
            userPO = new UserPO();
            userPO.setNickname("落樱");
        }
        return userPO;
    }

    @Override
    public UserPO findUser(String account, String password) {
        UserPO userPO = userMapper.selectOne(new LambdaQueryWrapper<UserPO>().eq(UserPO::getAccount, account)
                .eq(UserPO::getPassword,password)
                .select(UserPO::getAccount, UserPO::getId, UserPO::getAvatar, UserPO::getNickname)
                .last("limit 1"));

        return userPO;
    }

    @Override
    public UserPO findUserByAccount(String account) {
        UserPO userPO = userMapper.selectOne(new LambdaQueryWrapper<UserPO>().eq(UserPO::getAccount, account).last("limit 1"));
        return userPO;
    }

    @Override
    public void save(UserPO userPO) {
        userMapper.insert(userPO);

    }

    @Override
    public UserPO checkToken(String token) {
        if (org.apache.commons.lang3.StringUtils.isBlank(token)){
            return null;
        }
        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
        if (stringObjectMap == null){
            return null;
        }
        String userJson = redisTemplate.opsForValue().get("TOKEN_" + token);
        if (org.apache.commons.lang3.StringUtils.isBlank(userJson)){
            return null;
        }
        UserPO userPO = JSON.parseObject(userJson, UserPO.class);
        return userPO;
    }
}
