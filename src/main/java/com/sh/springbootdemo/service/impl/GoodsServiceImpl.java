package com.sh.springbootdemo.service.impl;

import com.sh.springbootdemo.dao.GoodsDao;
import com.sh.springbootdemo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsDao goodsDao;
    @Override
    @Transactional(propagation=REQUIRES_NEW)
    public double sellGoods(String id, int size,String userId) {
        return goodsDao.sellGoods(id,size,userId);
    }

    @Override
    public double getMoney(String id, int size) {
        return goodsDao.getMoney(id,size);
    }

    @Override
    public double sellGoods(String id, int size) {
        return goodsDao.sellGoods(id,size);
    }

}
