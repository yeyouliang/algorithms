package com.yeyouliang.jianzhi;

/**
 * Created by YYL on 2021/10/29 : 14:59.
 */
public class Offer_2_018 {
    /**
     * 剑指 Offer II 018. 有效的回文
     * */
    public static void main(String[] args) {
        String[] strings = {
                "",
                ",",
                ",,",
                ",,,",
                "a",
                "a,",
                ",a",
                "a,,",
                ",a,",
                ",,a",
                "aa",
                "aA",
                "aa,",
                "aA,",
                "a,a",
                "a,A",
                ",aa",
                ",aA",
                "aa,,",
                "aA,,",
                "a,a,",
                "a,A,",
                "a,,a",
                "a,,A",
                ",,aa",
                ",,aA",
                ",a,a",
                ",a,A",
                ",,aa",
                ",,aA",
                "ab",
                "ab,",
                "a,b",
                ",ab",
                "ab,,",
                "a,b,",
                "a,,b",
                ",ab,",
                ",a,b",
                ",,ab",
                "A man, a plan, a canal: Panama",
                "race a car"
        };
        for (String string : strings) {
            System.out.println(string + ":" + isPalindrome(string));
        }
    }

    private static boolean isPalindrome(String s) {
        if (s.length() > 1) {
            int start = 0;
            int end = s.length() - 1;
            while (start < end) {
                char c = s.charAt(start);
                if (c < 48 || (c > 57 && c < 65) || (c > 90 && c < 97) || c > 122) {
                    start++;
                } else {
                    while (start < end) {
                        char d = s.charAt(end);
                        if (d < 48 || (d > 57 && d < 65) || (d > 90 && d < 97) || d > 122) {
                            end--;
                        } else {
                            if (c == d || ((c > 57 && d > 57) && (c < 97 ? (c + 32 == d) : (c - 32 == d)))) {
                                start++;
                                end--;
                                break;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
