package com.gimelle.sandbox.problems;

import com.gimelle.sandbox.problems.fizzbuzz.FizzBuzzMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.gimelle.sandbox.problems.fizzbuzz.FizzBuzzMapper.fibuzOptional;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class FizzBuzzTest {

/*

Problem : For a given natural number greater than zero return:
    “Fizz” if the number is dividable by 3
    “Buzz” if the number is dividable by 5
    “FizzBuzz” if the number is dividable by 15
    the same number if number is neither divisible by 3 nor 5.

Read more: http://javarevisited.blogspot.com/2015/04/fizzbuzz-solution-in-java-8.html#ixzz5F69UbWad
*/

    @Test
    public void NothingTest() {
        assertThat(fibuzOptional(1), equalTo("1"));
        assertThat(fibuzOptional(2), equalTo("2"));
    }

    @Test
    public void FizzTest() {
        assertThat(fibuzOptional(3), equalTo("Fizz"));
        assertThat(fibuzOptional(9), equalTo("Fizz"));
    }

    @Test
    public void BuzzTest() {
        assertThat(fibuzOptional(5), equalTo("Buzz"));
        assertThat(fibuzOptional(20), equalTo("Buzz"));
    }

    @Test
    public void FizzBuzzTest() {
        assertThat(fibuzOptional(15), equalTo("FizzBuzz"));
        assertThat(fibuzOptional(45), equalTo("FizzBuzz"));
    }

    @Test
    public void FizzBuzzCollectionTest() {

        assertThat(FizzBuzzMapper.fibuzs(Arrays.asList(1, 2, 3, 4, 15, 20, 21, 22, 50)),
                equalTo(Arrays.asList("1", "2", "Fizz", "4", "FizzBuzz", "Buzz", "Fizz", "22", "Buzz")));
    }

}
