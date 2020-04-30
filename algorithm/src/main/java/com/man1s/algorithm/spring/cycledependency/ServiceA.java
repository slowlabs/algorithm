package com.man1s.algorithm.spring.cycledependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class ServiceA {

    @Value("${serviceA.value}")
    private String value ;

    @Autowired
    private  ServiceA serviceA;

}

@Service
class ServiceB{
    @Autowired
    private ServiceA serviceA;

}
