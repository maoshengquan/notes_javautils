package com.crazyfur.basic.javabasic.jdk18.lambda;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/7/4 0004
 * //TODO
 */
public class Main {

    public static void main(String[] args) {

        //new Thread(()-> System.out.println(Thread.currentThread().getName())).start();

        /*InterFun interFun = (a,b)->{
            System.out.println("sayHello");
            System.out.println(a+b);
            return a+b;
        };

        interFun.sayHello(1,2);
        InterFun interFun2 = (a,b)->{return a+b;};*/

        /*List<String> list = new ArrayList<>();
        list.add("123");
        list.add("321");
        list.add("223");
        list.forEach(s->{
            System.out.println(s);
        });*/




        //1. list.sort((o1,o2)->{return o1.getAge() - o2.getAge();});
//        list.sort((o1,o2)-> o1.getAge() - o2.getAge());
//        list.forEach(cur-> System.out.println(cur));

//        Set<User> set = list.stream().collect(Collectors.toSet());
//        collect.forEach(cur-> System.out.println(cur));

//        Map<String, User> collect = set.stream().collect(Collectors.toMap(new Function<User, String>() {
//            @Override
//            public String apply(User user) {
//                return user.getName();
//            }
//        }, new Function<User, User>() {
//            @Override
//            public User apply(User user) {
//                return user;
//            }
//        }));

//        Map<String, User> collect2 = set.stream().collect(Collectors.toMap(User -> User.getName(), User -> User));
//
//        collect2.forEach((k,v)->{
//            System.out.println(k+" "+v);
//        });

        List<User> list = new ArrayList<>();
        list.add(new User("a", 2));
        list.add(new User("b",1));
        list.add(new User("c",4));
        list.add(new User("d", 3));
        list.add(new User("e",5));
        list.add(new User("f",6));

//        Optional<User> sum = list.stream().reduce(((user1, user2) -> {
//            User user = new User("sum", user1.getAge() + user2.getAge());
//            return user;
//        }));
//        System.out.println(sum.get());
//
//
//        // 最大值
//        Optional<User> max = list.stream().max((o1, o2) -> o1.getAge() - o2.getAge());
//        System.out.println(max.get());
//
//        // anyMatch(其中一个匹配返回true)
//        boolean b = list.stream().anyMatch(user -> user.getAge() == 5);
//        System.out.println(b);
//
//        Stream<User> userStream = list.stream().filter((user) -> user.getAge() < 3 && user.getName().equals("a"));
//        userStream.forEach(cur-> System.out.println(cur));

        // 分页
//        Stream<User> limit = list.stream().skip(2).limit(2);
//        limit.forEach(cur-> System.out.println(cur));

        // 排序
        // list.stream().sorted((o1,o2) -> o2.getAge()-o1.getAge()).forEach(cur-> System.out.println(cur));


        // 排序，分页
        // list.stream().sorted(((o1, o2) -> o2.getAge()-o1.getAge())).skip(2).limit(2).forEach(cur-> System.out.println(cur));


        // 并行计算
        Instant now1 = Instant.now();
        LongStream longStream = LongStream.rangeClosed(1, 500000000);
        OptionalLong reduce = longStream.parallel().reduce((o1, o2) -> o1 + o2);
        System.out.println(reduce.getAsLong());
        Instant now2 = Instant.now();
        System.out.println(Duration.between(now1,now2).toMillis());


    }

}
