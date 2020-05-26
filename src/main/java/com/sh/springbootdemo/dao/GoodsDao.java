package com.sh.springbootdemo.dao;

import com.sh.springbootdemo.bean.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsDao {
    int addGoods(Goods goods);
    int sellGoods(@Param("id") String id,@Param("size") int size,@Param("userId") String userId);
    double getMoney(@Param("id") String id,@Param("size") int size);
    int sellGoods(@Param("id") String id,@Param("size") int size);
}
