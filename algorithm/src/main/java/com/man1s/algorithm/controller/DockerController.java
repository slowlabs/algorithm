package com.man1s.algorithm.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DockerController {
    static Log log = LogFactory.getLog(DockerController.class);


    @RequestMapping("/")
    public @Null String index(@Max(10) Integer a) {
        List<Integer> list = new ArrayList<>();
        list.add(a);
        try {
            System.out.println("tesing");
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Hello Docker!");
        return "Hello Docker!";
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
    }
}