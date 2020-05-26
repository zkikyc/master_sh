package com.kikyc.utils.controller;

import com.kikyc.utils.entity.Xs0101;
import com.kikyc.utils.service.Xs0101Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xs0101")
@Api("学生接口")
public class Xs0101Controller {
    @Autowired
    Xs0101Service xs0101Service;

    @ApiOperation(value = "按姓名查询学生",notes = "输入学生姓名查询学生信息",httpMethod = "GET")
    @ApiImplicitParam(dataType = "string",name = "xm",value = "姓名",required = true)
    @RequestMapping("/getXs0101ByXm")
    public Xs0101 getXs0101ByXm(@RequestParam("xm")String xm){
        return xs0101Service.selectByXm(xm);
    }

}
