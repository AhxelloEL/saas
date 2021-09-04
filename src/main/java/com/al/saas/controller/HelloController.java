package com.al.saas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.controller
 * @ClassName:HelloController
 * @Description
 * @date2021/9/2 15:38
 */
@RestController
@RequestMapping("hi")
public class HelloController {
    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello SpringSecurity";
    }
}
