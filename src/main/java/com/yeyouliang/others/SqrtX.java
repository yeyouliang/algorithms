package com.yeyouliang.others;

/**
 * Created by YYL on 2021/5/5 : 16:13.
 */
public class SqrtX {
    public static void main(String[] args) {

    }

    public static int half(int n,int start,int end){
        int h=end/2;
        int a=h*h;
        if (a<n){
            return half(n,h,start);
        }else if (a>n){
            
        }
    }
}
