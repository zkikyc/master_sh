package com.kikyc.utils.utils;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

/**
 * 字符串相关方法 by kikyc
 */
public  class StringUtils {
    /**
     * 判断字符串是否为空或者null
     * @param str
     * @return true 是
     */
    public static boolean isNullOrBlank(String str) {
        if (str == null) {
            return true;
        }
        //空格去除后在进行比较
        else if ("".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取32位大写随机字符串
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }

    /**
     * 获取指定字符串在源字符串中出现的次数
     * @param st 字符串
     * @param str 源字符串
     * @return
     */
    public static int getTimesOfString(String st,String str){
        int i =0;
        if(isNullOrBlank(str)){
            return i;
        }
        else{
            while(str.indexOf(st)!=-1){
                i++;
                str = str.substring(str.indexOf(st)+1,str.length());
                System.out.println(str);
            }
        }
        return i;
    }
}
