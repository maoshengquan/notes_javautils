package com.msq.utils.bloomfilter;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.msq.utils.bloomfilter.BulonFilter
 * @description
 * @date 2021/3/10 0010
 * //TODO
 */

import java.util.BitSet;
import java.util.logging.Logger;

/** 这是一个自己实现的布隆过滤器
 * 使用加乘HASH
 * 32MB内存
 * 注意Java的BitSet(size)只支持int，所以最大也就int最大值那么大
 * 7个Hash
 */
public class BulonFilter {

    // 32MB的位图
    private static final int BIT_SIZE = 1<<28;
    private final int[] hashSeeds = new int[]{31,37,41,43,47,53,69};
    private Hash[] hashes = new Hash[7];
    private BitSet bits = new BitSet(BIT_SIZE);
    private BitSet bits2 = new BitSet();
    private Logger bulonLogger = Logger.getLogger("BulonLogger");

    /**初始化HASH*/
    private boolean initHashes(){
        try{
            for(int i=0;i<7;i++){
                hashes[i] = new Hash(hashSeeds[i]);
            }
            return true;
        }
        catch (Exception e){
            bulonLogger.severe("初始化Hashes失败");
            return false;
        }
    }

    /**初始化函数里调用initHash()*/
    BulonFilter(){
        if(initHashes()){
            bulonLogger.info("布隆过滤器初始化成功");
        }
        else{
            bulonLogger.severe("布隆过滤器初始化失败");
        }
    }

    /**添加字符串*/
    public boolean add(String str){
        if(str==null){
            bulonLogger.info("添加的字符串为空");
            return false;
        }
        if(contains(str)){
            return false;
        }
        try {
            for (int i = 0; i < 7; i++) {
                bits.set(hashes[i].getHash(str, BIT_SIZE));
            }
            return true;
        }
        catch (Exception e){
            bulonLogger.warning("加入字符串："+str+"出错");
            return false;
        }
    }

    /**判断字符串是否在其中*/
    public boolean contains(String str){
        if(str==null){
            bulonLogger.info("字符串为空");
            return false;
        }
        for(int i=0;i<7;i++){
            if(!bits.get(hashes[i].getHash(str,BIT_SIZE))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        BulonFilter bulonFilter = new BulonFilter();

        for (int i = 1; i < 1000000;i++){
            bulonFilter.add(i+"");
        }

        System.out.println(bulonFilter.contains("-1024"));

        long end = System.currentTimeMillis();
        System.out.println("(end-start)="+(end -start));
    }
}

//使用加乘哈希，只需要选取不同的乘数，就能构造出不同的Hash
class Hash{
    int seed;
    Hash(int seed){
        this.seed = seed;
    }
    public int getHash(String str, int size){
        //避免int溢出
        Long result = 0L;
        for(int i=0;i<str.length();i++){
            result = result * seed + str.charAt(i);
        }
        //使用与运算将Hash值变为size内的值
        return (int)((size-1) & result);
    }

}
