package com.example.AgileBackEnd.utils;

import com.example.AgileBackEnd.entity.po.UserPO;

public class UserThreadLocal {
    private UserThreadLocal(){}
    
    public static final ThreadLocal<UserPO> LOCAL = new ThreadLocal<>();

    public static void put(UserPO userPO){
        LOCAL.set(userPO);
    }

    public static UserPO get(){
        return LOCAL.get();
    }

    public static void remove(){
        LOCAL.remove();
    }
}
