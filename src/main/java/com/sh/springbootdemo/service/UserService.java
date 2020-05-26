package com.sh.springbootdemo.service;

import com.sh.springbootdemo.bean.Xs0101;
import org.springframework.stereotype.Service;

public interface UserService {
    Xs0101 getXs0101ByXm(String xm);

    boolean buyGoods(String id,double money);

    double getMoney(String id);
}
