package com.kikyc.utils.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    /**
     * 根据所传时间和格式返回对应的时间字符串
     * @param date
     * @param format
     * @return
     */
    public static String getFormat(Date date, String format){
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String dateString = formatter.format(date);
        return dateString;
    }
}
