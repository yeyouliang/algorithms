package com.yeyouliang.others;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by YYL on 2021/6/20 : 21:31.
 */
public class PrintStack {
    public static void main(String[] args) {
        File file = new File("Y://kkfi");
        try {
            boolean newFile = file.createNewFile();
        } catch (IOException e) {
            StringWriter sw = new StringWriter();
            PrintWriter printWriter = new PrintWriter(sw);
            e.printStackTrace(printWriter);
            System.out.println(sw);
            //e.printStackTrace();
        }
    }
}
