package com.example.AgileBackEnd.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.AgileBackEnd.entity.po.UserPO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper  extends BaseMapper<UserPO> {
}
