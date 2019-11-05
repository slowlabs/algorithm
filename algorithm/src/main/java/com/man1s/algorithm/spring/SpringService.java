package com.man1s.algorithm.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class SpringService {


    public String testProtoType(){
        return  this.toString();
    }
}
