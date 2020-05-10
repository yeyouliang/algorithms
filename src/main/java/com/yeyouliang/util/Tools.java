package com.yeyouliang.util;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * Created by YEYOULIANG on 2020/4/28.
 */
public class Tools {
    public static Integer[] getRandomInt(int end, int count) {
        Random random = new Random();
        Set<Integer> integers = new HashSet<>();
        do {
            integers.add(random.nextInt(end));
        } while (integers.size() < count);
        return integers.toArray(new Integer[count]);
    }

    @Test
    public void chufa() {
        for (int i = 11; i < 2000; i++) {
            String shi = String.valueOf(i);
            String er = Integer.toBinaryString(i);
            String ba = Integer.toOctalString(i);
            if (ishuiWen(shi) && ishuiWen(er) && ishuiWen(ba)) {
                System.out.println("十进制、二进制和八进制都为回文的数是：" + shi);
                System.out.println("二进制：" + er + "，八进制：" + ba);
            }
        }
    }

    public boolean ishuiWen(String s) {
        int sl = s.length();
        for (int i = 0; i < sl; i++) {
            if (!String.valueOf(s.charAt(i)).equals(String.valueOf(s.charAt(sl - 1 - i)))) {
                return false;
            }
        }
        return true;
    }

    /*public boolean size(String s,int ii){
        String ss[]=s.split("");
        char c='+';
        if (Integer.valueOf(ss[0]))
    }*/

    @Test
    public void te() {
        char c = '2';
        System.out.println(c);
        int i = c;
        System.out.println(i);
        System.out.println(reverseString("1"));
    }

    @Test
    public void tt() {//对1000～9999的数，插入四则运算符，等于反转后的数。未实现。
        int[][] ints = {{1, 2, 3, 4}, {12, 3, 4}, {1, 23, 4}, {1, 2, 34}, {12, 34}, {123, 4}, {1, 234}};
        int num = 1024;//Integer的reverse方法不是用来反转十进制的
        String[] s = String.valueOf(num).split("");
        int[][] in = {
                {Integer.valueOf(s[0]), Integer.valueOf(s[1]), Integer.valueOf(s[2]), Integer.valueOf(s[3])},
                {Integer.valueOf(s[0] + s[1]), Integer.valueOf(s[2]), Integer.valueOf(s[3])},
                {Integer.valueOf(s[0]), Integer.valueOf(s[1] + s[2]), Integer.valueOf(s[3])},
                {Integer.valueOf(s[0]), Integer.valueOf(s[1]), Integer.valueOf(s[2] + s[3])},
                {Integer.valueOf(s[0] + s[1]), Integer.valueOf(s[2] + s[3])},
                {Integer.valueOf(s[0] + s[1] + s[2]), Integer.valueOf(s[3])},
                {Integer.valueOf(s[0]), Integer.valueOf(s[1] + s[2] + s[3])}
        };
        int reverseNum = Integer.valueOf(reverseString(String.valueOf(num)));

    }

    public String reverseString(String source) {//反转字符串
        int length = source.length();
        int index = length;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(source.charAt(index - 1));
            index--;
        } while (index > 0);
        return sb.toString();
    }

    @Test
    public void fan() {
        for (int i = 2; i <= 100; i++) {
            for (int j = 0; j <= ((100 - i) / i); j++) {
                System.out.print((i + i * j) + ",");
            }
            System.out.println(";");
        }
    }

    @Test
    public void fanpai() {
        System.out.print("背面朝上的牌的数字为：");
        for (int i = 2; i <= 100; i++) {
            if (beixliangshang(i)) {
                System.out.print(i + ",");
            }
        }
    }

    public boolean beixliangshang(int in) {
        int count = 0;
        for (int i = 2; i <= in; i++) {
            if ((in - i) % i == 0) {
                count++;
            }
        }
        if (count > 0 && count % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void erfenchazhao() {
        System.out.println(erfenchazhaoReturnIndex(0, in.length - 1, 6));//对已排好序的整数数组，查找一个数在其中的下标。
    }

    public static int[] in = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public int erfenchazhaoReturnIndex(int start, int end, int param) {
        int diff = end - start;
        int middleIndex = start + diff / 2;
        if (in[start] == param) {
            return start;
        } else if (in[end] == param) {
            return end;
        } else if (in[middleIndex] == param) {
            return middleIndex;
        } else if (in[middleIndex] < param) {
            return erfenchazhaoReturnIndex(middleIndex + 1, end - 1, param);
        } else {
            return erfenchazhaoReturnIndex(start + 1, middleIndex - 1, param);
        }
    }

    public int qieGeMu(int n, int m) {
        int base = 0;
        int num = 0;
        for (int i = 0; i < 50; i++) {
            base += Math.pow(2, i);
            if (m >= i * i && m < ((i + 1) * (i + 1))) {
                num = i + 1;
                break;
            }
        }
        int diff = n - 1 - base;
        int re = diff / m;
        int yu = diff % m;
        return yu == 0 ? (num + re) : (num + re + 1);
    }

    @Test
    public void qieGeMuTou() {
        int n = 100;
        int m = 5;
        System.out.println("当n=" + n + "，m=" + m + "时的最少切分次数为：" + qieGeMu(n, m));
    }

    //System.out.println("500元" + i + "张，100元" + j + "张，50元" + k + "张，10元" + l + "张");
    @Test
    public void change() {
        int count = 0;
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 10; j++) {
                for (int k = 0; k <= 15; k++) {
                    for (int l = 0; l <= 15; l++) {
                        if ((500 * i + 100 * j + 50 * k + 10 * l == 1000) && (i + j + k + l) <= 15) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println("一共会出现" + count + "种组合");
    }

    public static int zlCount = 0;
    public static int[] ins = {500, 100, 50, 10};

    public void change(int index, int num, int count) {
        if (index == ins.length) {
            return;
        }
        int a = ins[index];
        int current = count / a;
        for (int i = 0; (i <= current && i <= num); i++) {
            if (count == i * a) {
                zlCount++;
            } else {
                change(index + 1, num - i, count - a * i);
            }
        }
    }

    @Test
    public void getChange() {
        change(0, 15, 1000);
        System.out.println("一共会出现" + zlCount + "种组合");
    }

    @Test
    public void gongjing() {//五家共井
        for (int i = 1; i < 1000; i++) {
            for (int j = 1; j < 1000; j++) {
                int len = i * 2 + j;
                int three = len - j * 3;
                int four = len - three * 4;
                int five = len - four * 5;
                if ((i * 2 + j == j * 3 + three) && (j * 3 + three == three * 4 + four) && (three * 4 + four == four * 5 + five) && (four * 5 + five == five * 6 + i)) {
                    System.out.println("one=" + i + ",two=" + j + ",three=" + three + ",four=" + four + ",five=" + five + ",len=" + len);
                }
            }
        }
    }

    public static int kaoCount = 0;

    @Test
    public void kaolazi() {//fail
        for (int i = 2; i < 1000; i++) {
            if (i % 2 == 0) {
                kao(1, i, i);
            }
        }
        System.out.println(kaoCount);
    }

    public void kao(int num, int first, int now) {
        if (num == 1 || now % 2 == 1) {
            now = now * 3 + 1;
        } else {
            now /= 2;
        }
        if (num > 100) {
            System.out.println("no long");
            return;
        }
        if (first == now) {
            System.out.println("first=" + first);
            kaoCount++;
            return;
        } else {
            kao(++num, first, now);
        }
    }

    public static int lu = 0;

    public void sd() {
        int bu = 12;
        for (int i = 1; i <= 12; i++) {
            for (int j = 0; j <= bu - i; j++) {

            }
        }
    }

    public void sdd(int x, int y, int bu) {
        for (int i = 1; i <= 3; i++) {

        }
    }

    @Test
    public void http() {//fail
        doGet("http://0:0:0:0:0:0:0:1:8080/");
    }

    public String doGet(String httpurl) {
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;// 返回结果字符串
        try {
            // 创建远程url连接对象
            URL url = new URL(httpurl);
            // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接方式：get
            connection.setRequestMethod("GET");
            // 设置连接主机服务器的超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取远程返回的数据时间：60000毫秒
            connection.setReadTimeout(60000);
            // 发送请求
            connection.connect();
            // 通过connection连接，获取输入流
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                // 封装输入流is，并指定字符集
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                // 存放数据
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                while ((temp = br.readLine()) != null) {
                    System.out.println(temp);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            connection.disconnect();// 关闭远程连接
        }

        return result;
    }

    class Dui {
        private Dui left;
        private Dui right;
        private Integer value;

        public Dui(Dui left, Dui right, Integer value) {
            this.left = left;
            this.right = right;
            this.value = value;
            System.out.println("" + left + "," + value + "," + right);
        }

        public Dui getLeft() {
            return left;
        }

        public void setLeft(Dui left) {
            this.left = left;
        }

        public Dui getRight() {
            return right;
        }

        public void setRight(Dui right) {
            this.right = right;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }

    @Test
    public void duiPai() {
        Integer[] in = {5, 1, 13, 3, 16, 7, 10, 14, 6, 9, 4};
        int len = in.length;
        Dui[] dd = new Dui[len];
        for (int i = len - 1; i >= 0; i--) {
            Dui ld = null;
            Dui rd = null;
            if (2 * i + 2 < len) {
                rd = dd[2 * i + 2];
            }
            if (2 * i + 1 < len) {
                ld = dd[2 * i + 1];
            }
            Dui zhe = new Dui(ld, rd, in[i]);
            dd[i] = zhe;
        }
    }

    public void duip(Dui dui) {
        Dui left = dui.getLeft();
        Dui right = dui.getRight();
        if (null != right.getValue()) {
            if (right.getValue() < dui.getValue()) {
                Integer fu = right.getValue();
                right.setValue(dui.getValue());
                if (left.getValue() < fu) {
                    Integer zuo = left.getValue();
                    left.setValue(fu);
                    dui.setValue(zuo);
                    duip(left);
                } else {
                    dui.setValue(fu);
                }
            }
        } else if (null != left.getValue() && left.getValue() < dui.getValue()) {
            Integer le = left.getValue();
            left.setValue(dui.getValue());
            dui.setValue(le);
        }
    }

}
