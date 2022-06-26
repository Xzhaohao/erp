package org.kuro.erp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderNo {

    // 生成指定长度的随机数
    public static int genRandomNum(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        return (int) ((random * num));
    }


    // 生成订单流水号
    public static String genOrderNoDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowDate = sdf.format(new Date());

        String[] arr = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
                "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int n = Integer.parseInt(nowDate.substring(0, 4)) - 2022;

        String orderNumber = nowDate.substring(4);
        int num = genRandomNum(4);
        orderNumber = arr[n] + orderNumber + num;
        return orderNumber;
    }
}
