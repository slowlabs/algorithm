package com.man1s.algorithm;

import com.man1s.algorithm.algorithm.thread.ThreadPool;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DockerController {
    static Log log = LogFactory.getLog(DockerController.class);


    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        List<String> list = new ArrayList<>();
        list.add("1");
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