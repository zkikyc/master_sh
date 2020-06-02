package com.kikyc.utils.reptile.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOUtils {

    //将html页面内容读取成行存入list
    public static List<String> readLines(InputStream inputStream) {
        String line;
        List<String> list = new ArrayList<String>();
        try {
            //进行转换时，需要处理编码格式问题
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static byte[] toByteArray(InputStream inputStream) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            byte[] buffer = new byte[1024 * 4];
            int n = 0;
            while (-1 != (n = inputStream.read(buffer))) {
                output.write(buffer, 0, n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output.toByteArray();
    }
    //将html页面内容读取成行存入list 指定url
    public static List<String> readLines(InputStream inputStream,String url) {
        String line;
        List<String> list = new ArrayList<String>();
        try {
            String encode = PageEncoding.getEncodingByContentStream(url);
            //进行转换时，需要处理编码格式问题
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, encode));
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
