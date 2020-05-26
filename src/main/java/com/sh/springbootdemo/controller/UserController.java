package com.sh.springbootdemo.controller;


import com.sh.springbootdemo.bean.User;
import com.sh.springbootdemo.bean.Xs0101;
import com.sh.springbootdemo.service.GoodsService;
import com.sh.springbootdemo.service.UserService;
import com.sh.springbootdemo.utils.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")
@Import(value = {com.sh.springbootdemo.bean.Import.class})
@Api("用户")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private GoodsService goodsService;
    @Autowired
    RedisUtils rd;

    @Autowired
    private User user;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @ApiOperation(value = "按姓名查询学生",notes = "输入学生姓名查询学生信息",httpMethod = "GET")
    @ApiImplicitParam(dataType = "string",name = "xm",value = "姓名",required = true)
    @RequestMapping("/getByName")
    public Xs0101 getXs0101ByXm(@RequestParam("xm") String xm) {
//        Xs0101 xs0101 = (Xs0101) rd.get(xm);
        Xs0101 xs0101 = new Xs0101();
        if (xs0101.getXh() != null) {
            xs0101.setZymc("缓存专业");
            return xs0101;
        } else {
            xs0101 = userService.getXs0101ByXm(xm);
            if (xs0101 != null) {
//                rd.set(xm, xs0101);
//                rd.lPush(xm+"-list",xs0101);
//                rd.zAdd(xm+"-add",xs0101,1);
                return xs0101;
            } else {
                return null;
            }
        }
    }
    @RequestMapping("/buyGoods")
    @Transactional
    public String buyGoods(@Param("userId") String userId, @Param("id") String id, @Param("size") int size) {
        double price = goodsService.getMoney(id, size);
        System.out.println(price);
        double money = userService.getMoney(userId);
        System.out.println(money);
//        if (money > (price*size)) {
//            System.out.println(goodsService.sellGoods(id, size));
//            return "7777";
        goodsService.sellGoods(id, size,null);
        userService.buyGoods(userId,price*size);
//        }
        return "66666";
    }
    @RequestMapping("/yml")
    public User getYml(){
        log.debug(user.toString());
        log.info(user.toString());
        return user;
    }
}
