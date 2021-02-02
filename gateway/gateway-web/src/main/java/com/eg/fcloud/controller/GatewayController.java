package com.eg.fcloud.controller;

import com.eg.fcloud.entity.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: CAOPING
 * @Date: 2021/2/2 09:36
 * @Description:
 */
@RestController
@Slf4j
public class GatewayController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/gateway/findAll")
    public String getGateway(){
        log.info("----- port: {}", port);
        return "ok";
    }

}
