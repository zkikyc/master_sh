package com.kikyc.utils.dao;

import com.kikyc.utils.entity.Xs0101;

public interface Xs0101Mapper {
    int deleteByPrimaryKey(String xs0101id);

    int insert(Xs0101 record);

    int insertSelective(Xs0101 record);

    Xs0101 selectByXm(String xm);

    int updateByPrimaryKeySelective(Xs0101 record);

    int updateByPrimaryKey(Xs0101 record);
}