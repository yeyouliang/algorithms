package com.yeyouliang.others;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/4/18 : 15:39.
 */
public class TowerOfHanoi {
    public static void main(String[] args) {
        int n=3;
        List<Integer> one=new ArrayList<>();
        for (int i = 1; i < n+1; i++) {
            one.add(i);
        }
        List<Integer> two=new ArrayList<>();
        List<Integer> three=new ArrayList<>();
        toh(one,two,three);
    }

    public static void toh(List<Integer> one,List<Integer> two,List<Integer> three){
        if (one.isEmpty() && (two.isEmpty() || three.isEmpty())){
            return;
        }
        if (!two.isEmpty()){
            if (two.isEmpty() || two.get(0)>one.get(0)){
                List<Integer> o=new ArrayList<>(one);
                o.remove(0);
                List<Integer> t=new ArrayList<>(two);
                t.add(0,one.get(0));
                toh(o,t,new ArrayList<>(three));
            }
            if (three.isEmpty() || three.get(0)>one.get(0)){
                List<Integer> o=new ArrayList<>(one);
                o.remove(0);
                List<Integer> t=new ArrayList<>(three);
                t.add(0,one.get(0));
                toh(o,new ArrayList<>(two),t);
            }
        }
    }
}
