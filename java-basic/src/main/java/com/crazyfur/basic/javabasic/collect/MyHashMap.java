package com.crazyfur.basic.javabasic.collect;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/8/9 0009
 * //TODO
 */
public class MyHashMap<K,V> {

    private List<Entry<K,V>> entryList = new ArrayList<>();

    static class Entry<K,V>{
        K k;
        V v;

        public Entry(K k,V v) {
            this.k = k;
            this.v = v;
        }
    }

    public void put(K k,V v){
        entryList.add(new Entry<>(k,v));
    }
}
