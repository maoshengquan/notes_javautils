package com.crazyfur.basic.javabasic.jdk18;

import com.crazyfur.basic.javabasic.jdk18.lambda.User;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/7/4 0004
 * //TODO
 */
public class OptionalTest {

    public static void main(String[] args) {

//        String uname = null;

//        String hello = Optional.ofNullable(uname).orElse("hello");
//        System.out.println(hello);


//        String uname = null;
//        boolean present = Optional.ofNullable(uname).filter(s -> "123".equals(s)).isPresent();
//        System.out.println(present);
//
//        String s = Optional.ofNullable(uname).orElseGet(() -> "321");
//        String s1 = Optional.ofNullable(uname).orElse("321");

        User user = new User("321",1);
        user.setName(null);
        String s = Optional.ofNullable(user).map(user1 -> user1.getName()).orElse("123");
        System.out.println(s);

    }

}
