package com.ken.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	@RequestMapping("/")
	public String demo() {
		return "第一次使用 docker 部署 springboot ";
	}
	public static void main(String[] args) {
		SpringApplication.run( DemoApplication.class, args);
	}

}
