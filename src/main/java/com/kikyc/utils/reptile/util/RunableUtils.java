package com.kikyc.utils.reptile.util;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.LinkedBlockingQueue;

public class RunableUtils {
    //定义待抓取的url  全局共享
    public static LinkedBlockingQueue<String> urlQueue = new LinkedBlockingQueue<String>();
    //使用set存储已抓取过的url  节省资源 避免重复抓取
    public static Set<String> urlSet = new TreeSet<String>();

    //添加url 需要判断当前url是否已抓取过  已抓取 不添加 返回0  未抓取 则添加  且当前url 队列中未存在
    public static int addUrl(String url) {
        int num = urlSet.size();
        urlSet.add(url);
        //表示当前url已经抓取过
        if (urlSet.size() == num) {
            return 0;
        }
        //和add均为添加一个元素至队列 add队列满时  抛出异常 offer 则返回false
        if (urlQueue.offer(url)) {
            return 1;
        }
        return 0;
    }
    //取出一个url
    public static String getOut(){
        //添加到已抓取的set集合中
        String url = urlQueue.peek();
        urlSet.add(url);
        //从队列中移除
        urlQueue.poll();
        return url;
    }

}
