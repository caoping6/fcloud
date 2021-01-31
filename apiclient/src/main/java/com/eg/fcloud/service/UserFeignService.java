package com.eg.fcloud.service;

import com.eg.fcloud.entity.Response;
import com.eg.fcloud.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "WEB-APP")
@Component
public interface UserFeignService {
    @GetMapping(value = "/cloud/webapp/user/findAll")
    public Response findAll();
}

