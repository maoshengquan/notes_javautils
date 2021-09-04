package com.crazyfur.basic.javabasic.config;

import com.crazyfur.basic.javabasic.annotation.FuntionName;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/7/3 0003
 * //TODO
 */
@Aspect
@Component
public class AuthAop {

    /**
     * 标有@FuntionName 的方法会被拦截
     * @param joinPoint
     * @return
     */
    @Around(value = "@annotation(com.crazyfur.basic.javabasic.annotation.FuntionName)")
    public Object around(ProceedingJoinPoint joinPoint){

        Object proceed = null;// 目标方法执行的结果
        try {
            // 获取目标方法
            Signature signature = joinPoint.getSignature();
            MethodSignature methodSignature = (MethodSignature)signature;
            FuntionName annotation = methodSignature.getMethod().getAnnotation(FuntionName.class);
            String perms = annotation.perms();
            System.out.println("调用该方法需要的权限："+perms);

            System.out.println("目标方法开始执行...");
            proceed = joinPoint.proceed();//调用目标方法
            System.out.println("目标方法执行完成...");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return proceed;
    }

}
