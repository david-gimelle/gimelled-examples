package com.gimelle.sandbox.javaeight;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StreamsTest {




    @Test
    public void streamToArraysTest(){
        Supplier<Stream<String>> petitioners = () -> Stream.of("Peti1","Pet2","Pet3");

        //toArray()
        Object[] objects = petitioners.get().toArray();
        assertThat(objects.length, equalTo(3));
        assertThat(objects instanceof Object[], equalTo(true));

        //toArray( with a lambda to build the array)
        String[] strings = petitioners.get().toArray(size -> new String[size]);
        assertThat(strings[1], equalTo("Pet2"));
        assertThat(strings instanceof String[], equalTo(true));

        //to have an array of primitive instead of objects
        IntStream intStream = petitioners.get().mapToInt(e -> e.length());
        int[] ints = intStream.toArray();
        assertThat(ints[0], equalTo(5));
        assertThat(ints instanceof int[], equalTo(true));

        //Using a collector
        ArrayList<String> collected = petitioners.get().collect(Collectors.toCollection(ArrayList::new));
        String[] strings2 = collected.toArray(new String[collected.size()]);
        assertThat(strings2[1], equalTo("Pet2"));
        assertThat(strings2 instanceof String[], equalTo(true));

        //The best way! -> The use method reference to build an array
        String[] strings1 = petitioners.get().toArray(String[]::new);
        assertThat(strings1[1], equalTo("Pet2"));
        assertThat(strings1 instanceof String[], equalTo(true));
    }

    @Test
    public void testMapFlatMap(){

        Stream<String> cars = Stream.of("carA", "carB", "carC");
        Stream<Stream<String>>  carss = Stream.of(Stream.of("carA"), Stream.of("carB", "carC"));

        Stream<String> CARS = cars.map(String::toUpperCase);
        Stream<String> sameCARS = carss.flatMap(s -> s.map(String::toUpperCase));

        assertThat(CARS.toArray(), equalTo(sameCARS.toArray()));
    }

    @Test
    public void streamDistinct(){

        List<Integer> integers = Arrays.asList(9, 10, 7, 3, 4, 3);

        assertThat(
                integers.stream().distinct().collect(Collectors.toList()),
                equalTo(
                        Stream.of(9,10,7,3,4).collect(Collectors.toList())
                )
        );

    }
}
