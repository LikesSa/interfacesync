package com.dqkj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello,Spring Boot";
    }



    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host","123");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }


}