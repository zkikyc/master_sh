package com.kikyc.utils.reptile.util;

import com.kikyc.utils.reptile.entity.Res;
import com.kikyc.utils.utils.DateUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

public class Cswzl {
    private  static String url = "http://www.cswzl.com";
    private static String actionUrl = "/lostinfo.action";
    private static Cswzl cswzl =null;

    public static Cswzl getInstance(String url,String actionUrl){
        if(cswzl ==null){
            cswzl = new Cswzl(url,actionUrl);
        }
        return cswzl;
    }

    public Cswzl(String url,String actionUrl){
        this.url = url;
        this.actionUrl = actionUrl;
    }
    public Cswzl() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("url", url);
        //爬取内容
        List<String> list = (List<String>) ReptileUtils.getHtml(map).getData();
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static List<Res> getByJsoup(){
        List<Res> list = new ArrayList<Res>();
        try {
            Document document = Jsoup.connect(url+actionUrl).get();
            Elements postItems = document.select(".info_title1");
            Elements es = postItems.select("tr");
            for (Element e : es) {
                String secUrl = url+e.getElementsByTag("a").attr("href").toString();
                Document d1 = Jsoup.connect(secUrl).get();
                Elements e1 = d1.getElementsByTag("table");
                //获取物品种类
                String resType = d1.select(".data_input").text();
                //获取详细信息
                String resDetails = d1.select(".data_input").parents().first().nextElementSibling().select("td").get(1).text();
                //获取酬谢方式
                String reward = d1.select(".data_input").parents().first().nextElementSiblings().get(1).select("td").get(1).text();
                //获取丢失地点
                String resLocation = d1.select(".data_input").parents().first().nextElementSiblings().get(2).select("td").get(1).text();
                //获取丢失时间
                String resTime = d1.select(".data_input").parents().first().nextElementSiblings().get(3).select("td").get(1).text();
                Date resTime1 =  DateUtils.StringToDate(resTime,"yyyy-MM-dd hh:mm");
                Res r = new Res(resType,resDetails,reward,resLocation,resTime1,secUrl);
                list.add(r);
            }
            return list;
        }
        catch (Exception e){
            System.out.println("系统异常!");
        }
        return null;
    }
    public static void main(String[] args) {
        List<Res> list= getByJsoup();
        System.out.println(list.size());
    }
}

