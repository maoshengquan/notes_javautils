package com.crazyfur.basic.javabasic.controller;

import com.crazyfur.basic.javabasic.annotation.FuntionName;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/7/3 0003
 * //TODO
 */
@RestController
public class AnnotationController {

    @FuntionName(perms = "add:update:del:query")
    @GetMapping("/index")
    public Object index(){
        System.out.println("...index...");
        return "ok";
    }

}
