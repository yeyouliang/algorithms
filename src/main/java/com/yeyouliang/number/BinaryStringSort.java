package com.yeyouliang.number;

import java.util.Arrays;

/**
 * Created by YYL on 2020/10/8.
 */
public class BinaryStringSort {
    /*
    * 00000000
    * 00000001
    * 00000010
    * 00000011
    * 00000100
    * 00000101
    * 00000110
    * 00000111
    * 00001000
    * 00001001
    * */
    public static void main(String[] args) {
        //String s="00000000";
        for (int i = 0; i <256; i++) {
            System.out.println(Integer.toBinaryString(i));
        }
    }

    public void bss(String string,int index){
        String s=string.trim();
        String ss=s.substring(0,index);
        String s1="";
        if (index!=string.length()-1){
            s1=string.substring(index+1);
        }
        System.out.println(ss+"1"+s1);
        if (!s1.equals("")){
            bs(ss+"1",s1);
        }
        if (index!=0){
            bss(string,index-1);
        }
    }

    public void bs(String pre,String post){

    }

}
