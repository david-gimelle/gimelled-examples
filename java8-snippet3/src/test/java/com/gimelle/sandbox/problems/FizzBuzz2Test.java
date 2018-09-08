package com.gimelle.sandbox.problems;


import com.gimelle.sandbox.problems.fizzbuzz.FizzBuzzMapper2;
import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


/*

Problem : For a given natural number greater than zero return:
    “Fizz” if the number is dividable by 3
    “Buzz” if the number is dividable by 5
    “FizzBuzz” if the number is dividable by 15
    the same number if number is neither divisible by 3 nor 5.

Read more: http://javarevisited.blogspot.com/2015/04/fizzbuzz-solution-in-java-8.html#ixzz5F69UbWad
*/


public class FizzBuzz2Test {

    FizzBuzzMapper2 testObj = new FizzBuzzMapper2();

    @Test
    public void returnFizzFor3() {
        assertThat(testObj.map(3).get(), equalTo("Fizz"));
    }

    @Test
    public void returnUpTo5() {
        assertThat(testObj.map(1).get(), equalTo("1"));
        assertThat(testObj.map(2).get(), equalTo("2"));
        assertThat(testObj.map(3).get(), equalTo("Fizz"));
        assertThat(testObj.map(4).get(), equalTo("4"));
        assertThat(testObj.map(5).get(), equalTo("Buzz"));
    }

    @Test
    public void returnEmptyUnder1() {
        assertThat(testObj.map(-1), equalTo(Optional.empty()));
        assertThat(testObj.map(0), equalTo(Optional.empty()));
    }

    @Test
    public void returnFizzBuzzfor45() {
        assertThat(testObj.map(45), equalTo(Optional.of("FizzBuzz")));
    }

    @Test
    public void mapperWorksOnStreamsOfInt() {
        assertThat(
                Stream.of(1, 2, 3, 4, 5, 6, 7, 15)
                        .map(FizzBuzzMapper2::map)
                        .map(Optional::get)
                        .collect(Collectors.toList()),
                equalTo(
                        Arrays.asList("1","2","Fizz","4","Buzz","Fizz","7","FizzBuzz")
                )
        );
    }

}
