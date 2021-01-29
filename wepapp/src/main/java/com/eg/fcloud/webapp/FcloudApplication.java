package com.eg.fcloud.webapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("com.eg.fcloud")
@MapperScan("com.eg.fcloud.*.mapper")
public class FcloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(FcloudApplication.class, args);
	}

}
