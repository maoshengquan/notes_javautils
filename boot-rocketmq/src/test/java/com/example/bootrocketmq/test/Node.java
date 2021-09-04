package com.example.bootrocketmq.test;

import lombok.Data;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/6/27 0027
 * //TODO
 */
@Data
public class Node {
    private Integer id;
    private String name;
    private String type;
    private Node next;
}
