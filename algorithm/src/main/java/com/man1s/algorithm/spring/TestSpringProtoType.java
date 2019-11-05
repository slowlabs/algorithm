package com.man1s.algorithm.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testSpring")
public class TestSpringProtoType {
    @Autowired
    private SpringService springService;
    @RequestMapping("")
    public String test(){
        System.out.println(springService.testProtoType());
        return  "";
    }


}
