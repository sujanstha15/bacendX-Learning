package com.substring.concepts.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Engine {

    private String companyName;
    @Autowired
    public Engine(@Qualifier("engineBean") String name) {
        this.companyName = name;
    }
    public Engine(){

    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void start(){
        System.out.println(companyName + " Engine starting");
        System.out.println(companyName+" Engine started");
        System.out.println("-----------------\n");
    }
}
