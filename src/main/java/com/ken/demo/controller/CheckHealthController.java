package com.ken.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckHealthController {

    @RequestMapping(value = "/health")
    public String health()
    {
        return "health/health";
    }

}
