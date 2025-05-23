package com.substring.concepts;

import com.substring.concepts.core.Car;
import com.substring.concepts.core.Engine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
        #This is hard coded, so we don't write this here. When we use spring , we don't do hard code. The spring container does everything for us.
        //this problem here is, we are creating object by ourself
        Engine engine = new Engine("Ford");
        Car tataSafari = new Car("Safari", engine);
        tataSafari.start();

        Engine engine2 = new Engine("Tata");
        Car nexon = new Car("Nexon", engine2);
        nexon.start();

         */
        //we will use spring container here, call
        //to represent container we have a interface  called applicationContext
        //we use applicationContext because it supports all types of configuration

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml"); //creating spring container
        Car car = context.getBean("car", Car.class); //id and name, name should match
        //Car.class is class literal, with the help of that we can know the type of bean
        car.start();


        //since we haven't created any object by ourselves, we have followed IOC








    }
}
