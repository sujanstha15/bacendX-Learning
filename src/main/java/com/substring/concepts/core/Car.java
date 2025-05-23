package com.substring.concepts.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {

    private String name;
    private Engine engine;

@Autowired
    public Car(@Qualifier("carBean") String name, Engine engine){
        this.name= name;
        this.engine = engine;
    }
    //default contrscutor
    public Car(){

    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //car needs engine to start, so we are injection engine object here.
    //private Engine engine = new Engine();
    //we removed the hard coded
    public void start(){
        //when the engine start, only then car will start making the Car class tightly coupled
        System.out.println(name + " Starting");
        engine.start();

    }
}
