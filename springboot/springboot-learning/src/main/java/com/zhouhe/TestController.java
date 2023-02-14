package com.zhouhe;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "hello " + name;
    }
}
