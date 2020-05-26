package com.sh.springbootdemo.dao;
import com.sh.springbootdemo.bean.Xs0101;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
public interface UserDao {
      Xs0101 getXs0101ByXm(@Param("xm") String xm);
      boolean buyGoods(@Param("id")String id,@Param("money") double money);
      double getMoney(@Param("userId") String id);
}
