package com.vaskka.icbcibm.car.utils;

import java.security.MessageDigest;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class Util {

    /**
     * md5加密
     * @param s 待加密明文
     * @return
     */
    public static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {

            return null;
        }
    }


    /**
     * 获取当前日期
     * @return
     */
    public static String getCurrentDate() {
        java.text.SimpleDateFormat f = new java.text.SimpleDateFormat("yyyyMMdd");
        return f.format(new Date());
    }

    /**
     * 获取当前时间
     * @return
     */
    public static String getCurrentTime() {
        java.text.SimpleDateFormat f = new java.text.SimpleDateFormat("hhmmss");
        return f.format(new Date());
    }

    /**
     * 得到指定最大宽度的随机数
     * @param length 最大宽度
     * @return
     */
    public static String getRandomNumber(int length) {
        if (length < 0 || length > 9) {
            return null;
        }

        Random random = new Random();

        return String.valueOf(random.nextInt((int) Math.pow(10, length)));
    }


    /**
     * 得到全局唯一的msg_id
     * @return String msg_id
     */
    public static String getMsgId() {
        String uuid =  UUID.randomUUID().toString();
        String frontStr = uuid.substring(0, 4);
        String endStr = uuid.substring(24, 36);

        return "MSG" + frontStr + getCurrentDate() + getCurrentTime() + endStr;

    }

    /**
     * 得到全局唯一的订单号
     * @return String order_id
     */
    public static String getOrderId() {

        String hash_full = MD5(getCurrentDate() + getCurrentTime() + getRandomNumber(1));

        return "ORDER" + getCurrentDate() + getCurrentTime() + hash_full.substring(0, 5);
    }




}

