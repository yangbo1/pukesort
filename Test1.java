package com.yb.test_02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杨波 on 2016/11/24.
 */
public class Test1 {
    private static List<String> list = new ArrayList<String>();
    /**初始化00000000*/
    public void init(){
        for (int i=0;i<8;i++){
            list.add("0");
        }
    }
    /**重新初始化为0*/
    public void reinit(){
        for (int i=0;i<8;i++){
            list.set(i,"0");
        }
    }
    /**输出*/
    public void output(){
        for (String s:list){
            System.out.print(s);
        }
        System.out.println();
    }

    /**判断算法*/
    public void run(){
        for (int a=0;a<3;a++){
            //同时放两个4
            list.set(a,"4");
            list.set(a+5,"4");
            for (int b=0;b<4;b++) {
                //不能在已有的位置上放
                if (b != a && b != (a + 1)) {
                    list.set(b, "3");
                    list.set(b + 4, "3");
                    for (int c = 0; c < 5; c++) {
                        if (c != a && c != (a - 3) && c != (a + 2) && c != b && c != (b + 1) && c != (b - 3) && c!=(b+4)) {
                            list.set(c, "2");
                            list.set(c + 3, "2");
                            for (int d = 0; d < 6; d++) {
                                if (d != a && d != (a + 5) && d != b && d != (b + 4) && d != c && d != (c + 3) && (d + 2) != a && (d + 2) != (a + 5) && (d + 2) != (b) && (d + 2) != (b + 4) && (d + 2) != (c) && (d + 2) != (c + 3)) {
                                    list.set(d, "A");
                                    list.set(d + 2, "A");
                                    output();
                                } else {
                                    continue;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                } else {
                    continue;//如果都牌放不进去，直接进行下一次循环。本次循环内部的循环都不执行。
                }
            }
            reinit();//每次放第一张牌的时候，重新给list置0。
        }
    }
    @Test
    public void test(){
        long startTime = System.currentTimeMillis();//获取当前时间
        init();
        run();
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间："+(endTime-startTime)+"ms");
    }
 }
