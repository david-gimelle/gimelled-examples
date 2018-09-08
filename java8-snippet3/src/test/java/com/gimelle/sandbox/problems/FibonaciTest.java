package com.gimelle.sandbox.problems;

import com.gimelle.sandbox.problems.fibo.FiboCalculator;
import org.junit.Test;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class FibonaciTest {

    @Test
    public void fibo2Elements() {

        //2 -> 1,1
        //Note that is the base case
        assertThat(FiboCalculator.generates(2), equalTo(Arrays.asList(1L, 1L)));
    }

    @Test
    public void fibo3Elements() {

        //3 -> 1,1,2

        assertThat(FiboCalculator.generates(3), equalTo(Arrays.asList(1L, 1L, 2L)));
    }

    @Test
    public void fibo5Elements() {

        //5 -> 1,1,2,3,5

        assertThat(FiboCalculator.generates(5), equalTo(Arrays.asList(1L, 1L, 2L,3L,5L)));
    }

    @Test
    public void fibo1And2(){
        assertThat(FiboCalculator.fibo(0), equalTo(0L));
        assertThat(FiboCalculator.fibo(1), equalTo(1L));
        assertThat(FiboCalculator.fibo(2), equalTo(1L));
    }

    @Test
    public void fibo3to6(){
        assertThat(FiboCalculator.fibo(3), equalTo(2L));
        assertThat(FiboCalculator.fibo(4), equalTo(3L));
        assertThat(FiboCalculator.fibo(5), equalTo(5L));
        assertThat(FiboCalculator.fibo(6), equalTo(8L));
    }


}
