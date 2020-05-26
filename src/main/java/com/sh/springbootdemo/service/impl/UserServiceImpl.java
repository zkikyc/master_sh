package com.sh.springbootdemo.service.impl;

import com.sh.springbootdemo.bean.Xs0101;
import com.sh.springbootdemo.dao.UserDao;
import com.sh.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Xs0101 getXs0101ByXm(String xm) {
        return userDao.getXs0101ByXm(xm);
    }

    @Override
    public boolean buyGoods(String id,double money) {
        return userDao.buyGoods(id,money);
    }

    @Override
    public double getMoney(String id) {
        return userDao.getMoney(id);
    }

}
