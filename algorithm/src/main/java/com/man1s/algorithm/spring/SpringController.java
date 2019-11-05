package com.man1s.algorithm.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/spring")
public class SpringController {
    static Log log = LogFactory.getLog(SpringController.class);

    @Autowired
    private SpringService springService;

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        System.out.println(springService.testProtoType());
        try {
            System.out.println("tesing");
            Thread.sleep(1000000);
            SpringController.class.getClassLoader().loadClass("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Hello Docker!");
        return "Hello Docker!";
    }
}