package com.sh.springbootdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
@Api("商品")
public class GoodsController {

    @ApiOperation(value = "商品",notes = "哈哈哈哈",httpMethod = "GET")
    @ApiImplicitParam(dataType = "string",name = "goodsName",value = "商品名",required = true)
    @RequestMapping("/getGoods")
    public String getGoods(String goodsName){
        return goodsName;
    }
}
