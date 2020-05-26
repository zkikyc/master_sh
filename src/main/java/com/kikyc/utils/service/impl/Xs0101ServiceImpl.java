package com.kikyc.utils.service.impl;

import com.kikyc.utils.dao.Xs0101Mapper;
import com.kikyc.utils.entity.Xs0101;
import com.kikyc.utils.service.Xs0101Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Xs0101ServiceImpl implements Xs0101Service {

    @Autowired
    Xs0101Mapper xs0101Mapper;
    @Override
    public Xs0101 selectByXm(String xm) {
        return xs0101Mapper.selectByXm(xm);
    }
}
