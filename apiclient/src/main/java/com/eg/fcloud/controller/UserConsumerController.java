package com.eg.fcloud.controller;

import com.eg.fcloud.entity.Response;
import com.eg.fcloud.entity.User;
import com.eg.fcloud.service.UserFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class UserConsumerController {
    private static final String WEB_APP = "http://WEB-APP";
    private static final String WEB_APP_URI = "/cloud/webapp/user/findAll";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private UserFeignService userFeignService;


    @GetMapping("user/findAll")
    public Response<User> getUsers(){
        ResponseEntity<Response> forEntity = restTemplate.getForEntity(WEB_APP + WEB_APP_URI, Response.class);
        log.info(forEntity.getStatusCode() + "\t" + forEntity.getBody());
        return Response.build(forEntity.getBody()).success();
    }


    @GetMapping("user/findAllFeign")
    public Response<User> getUsersFeign(){
        Response response = userFeignService.findAll();
        log.info(response.toString());
        return response;
    }
}
