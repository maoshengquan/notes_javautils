package com.crazyfur.basic.javabasic.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface FuntionName {

    /**
     * 注解属性
     * @return
     */
    String perms() default "";

}
