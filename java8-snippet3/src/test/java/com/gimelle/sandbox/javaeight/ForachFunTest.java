package com.gimelle.sandbox.javaeight;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ForachFunTest {


    @Test
    public void someForAndForeachJ7Example(){

        List<String> cars = Arrays.asList("Clio","Ka","Civic","500","Q7");

        for(String car : cars){
            System.out.println(">"+car);
        }

        for (int i=0; i< cars.size(); i++){
            System.out.println(i+"-"+cars.get(i));
        }

    }


    @Test
    public void someForEachOnStream(){
        Supplier<Stream<String>> cars = () -> Stream.of("Clio","Ka","Civic","500","Q7");

        cars.get().forEach(System.out::println);

        cars.get().forEach((e)-> System.out.println("e>"+e));
    }
}
