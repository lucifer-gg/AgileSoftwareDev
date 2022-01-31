package com.example.AgileBackEnd.aop.cacheAspect;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cache {

    //缓存组件

    long expire() default 1 * 60 * 1000;

    String name() default "";

}
