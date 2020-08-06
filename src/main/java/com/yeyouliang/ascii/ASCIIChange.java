package com.yeyouliang.ascii;

import org.junit.Test;

/**
 * Created by YEYOULIANG on 2020/7/25.
 */
public class ASCIIChange {
    public static void main(String[] args) {
        char a = 'a';//97
        char A = 'A';//65
        char z = 'z';//122
        char Z = 'Z';//90
        char zero = '0';//48
        char nine = '9';//57
        System.out.println("字符与它们的ASCII码对应关系为：");
        System.out.println(a + "->" + (int) a+ "," + z + "->" + (int) z + "," + A + "->" + (int) A  + "," + Z + "->" + (int) Z +
                "," + 0 + "->" + (int) zero + "," + nine + "->" + (int) nine);
        System.out.println((int) '<');//char转int
        System.out.println((char) 60);//int转char
    }

    @Test
    public void getColindexTest() {//根据Excel表的列名返回列的的索引
        System.out.println(getColindex("AAAAAAC"));
    }

    public int getColindex(String colStr) {
        int a = colStr.length();
        int count = 0;
        int diff = (int) colStr.charAt(a - 1) - 65 + 1;
        count += (a - 1) * 26 + diff;
        return count;
    }
}
