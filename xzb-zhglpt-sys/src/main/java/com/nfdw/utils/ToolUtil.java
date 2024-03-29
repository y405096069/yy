package com.nfdw.utils;

import java.util.Random;

public class ToolUtil {
    /**
     * 获取随机位数的字符串（数字）
     */
    public static String getRandomNumString(int length) {
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
