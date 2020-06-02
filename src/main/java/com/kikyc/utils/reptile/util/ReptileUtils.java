package com.kikyc.utils.reptile.util;

import com.kikyc.utils.entity.R;
import com.sun.deploy.net.HttpResponse;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class ReptileUtils {

    //指定路径 文件名  存储地址 获取整个页面内容
    public static R getHtml(Map<String, Object> map, HttpResponse response) {
        //不指定地址 抛出异常
        if (map.get("url") == null) {
            return R.getFailed("url不能为空");
        }
        String url = map.get("url") == null ? "" : map.get("url").toString();
        //不指定文件名 默认为sx.txt
        String fileName = map.get("fileName") == null ? "sx.html" : map.get("fileName").toString();
        //不指定路径 默认为d:/file
        String path = map.get("path") == null ? "D:/file" : map.get("path").toString();
        //不指定前缀  默认http请求
        String mode = map.get("mode") == null ? "http://" : map.get("mode").toString();
        String finUrl = mode + url;
        try {
            URL u = new URL(finUrl);
            //通过url建立与网页的连接
            URLConnection conn = u.openConnection();
            //通过链接取得网页返回的数据
            InputStream is = conn.getInputStream();
            //一般按行读取网页数据，并进行内容分析
            //因此用BufferedReader和InputStreamReader把字节流转化为字符流的缓冲流
            String encode = PageEncoding.getEncodingByContentStream(finUrl);
            //进行转换时，需要处理编码格式问题
            BufferedReader br = new BufferedReader(new InputStreamReader(is, encode));
            //按行读取
            String line = null;
            PrintWriter out = null;
            File file = new File(path + "/" + fileName);
            if (!file.exists()) {
                File dir = new File(file.getParent());
                dir.mkdirs();
                file.createNewFile();
            }
            try {
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), encode)));
                while ((line = br.readLine()) != null) {
                    out.write(line + "\n");

                }
            } catch (Exception e) {
                e.printStackTrace();
                return R.getFailed("系统异常！");
            } finally {
                if (br != null) {
                    br.close();
                }
                if (out != null) {
                    out.close();
                }
            }
            return R.getSuccess("操作成功!文件存储在:" + path + "/" + fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return R.getFailed("系统异常！");
        }
    }

    //指定路径 获取整个页面内容
    public static R getHtml(Map<String, Object> map) {
        //不指定地址 抛出异常
        if (map.get("url") == null) {
            return R.getFailed("url不能为空");
        }
        String url = map.get("url") == null ? "" : map.get("url").toString();
        try {
            URL u = new URL(url);
            //通过url建立与网页的连接
            URLConnection conn = u.openConnection();
            //通过链接取得网页返回的数据
            InputStream is = conn.getInputStream();
            return new R(200,"请求成功",IOUtils.readLines(is,url));
        } catch (Exception e) {
            e.printStackTrace();
            return R.getFailed("系统异常!");
        }
    }
}
