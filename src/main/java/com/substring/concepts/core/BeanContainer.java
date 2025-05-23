package com.substring.concepts.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanContainer {
    //creating bean, this bean will return TataSafari
    @Bean(name="carBean")
    public String carName(){
        return "TataSafari";
    }

    @Bean(name="engineBean")
    public String engineName(){
        return "Ford";
    }
}
