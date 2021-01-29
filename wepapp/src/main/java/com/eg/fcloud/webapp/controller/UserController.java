package com.eg.fcloud.webapp.controller;


import com.eg.fcloud.webapp.entity.User;
import com.eg.fcloud.webapp.model.Response;
import com.eg.fcloud.webapp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author caoping
 * @since 2021-01-28
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/webapp/user")
public class UserController{

    @Autowired
    private UserService userService;

    // 返回被@ApiModel标注的类对象
    @ApiOperation(value = "实体类响应",notes = "返回数据为实体类的接口")
    @GetMapping(value = "findAll")
    public Response findAll(){
        List<User> list = userService.list();
        return Response.build(list).success();
    }
    @GetMapping(value = "findById/{id}")
    public Response findById(@PathVariable Long id){
        List<User> list = userService.listByIds(Arrays.asList(id));
        return Response.build(list).success();
    }
}

