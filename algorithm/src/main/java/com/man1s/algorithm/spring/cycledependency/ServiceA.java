package com.man1s.algorithm.spring.cycledependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceA {
    private final ServiceA serviceA;

    @Autowired
    public ServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}

@Service
class ServiceB{
    @Autowired
    private ServiceA serviceA;

}
