package com.sh.springbootdemo.service;

import org.springframework.stereotype.Service;

@Service
public interface GoodsService {
    double sellGoods(String id,int size,String userId);

    double getMoney(String id,int size);

    double sellGoods(String id,int size);
}
