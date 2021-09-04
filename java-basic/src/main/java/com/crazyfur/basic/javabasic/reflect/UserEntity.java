package com.crazyfur.basic.javabasic.reflect;

import com.crazyfur.basic.javabasic.annotation.FuntionName;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/7/3 0003
 * //TODO
 */
public class UserEntity {

    private String username;
    private Integer userage;


    public UserEntity() {
        System.out.println("UserEntity()");
    }

    @FuntionName
    public void info(){
        System.out.println("info");
    }

    public UserEntity(String username, Integer userage) {
        System.out.println("UserEntity(String username, Integer userage)");
        this.username = username;
        this.userage = userage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserage() {
        return userage;
    }

    public void setUserage(Integer userage) {
        this.userage = userage;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "username='" + username + '\'' +
                ", userage=" + userage +
                '}';
    }
}
