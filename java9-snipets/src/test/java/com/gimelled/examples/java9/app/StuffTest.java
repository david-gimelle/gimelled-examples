package com.gimelled.examples.java9.app;

import org.junit.Test;

import java.util.List;

public class StuffTest {

    @Test
    public void testString(){
        String toto1 = "toto";
        String toto2 = "toto";
        String toto3 = new String("toto");

        System.out.println("toto1 == toto2"+ (toto1 == toto2));
        System.out.println("toto2 == toto3"+ (toto2 == toto3));

        List<Integer> integers = List.of(1);
    }
}
