package com.gimelle.sandbox.recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RecursionTest {

    @Test
    public void calculateRecursionFactorial() {
        assertThat(factorial(1), equalTo(1L));
        assertThat(factorial(0), equalTo(1L));
        assertThat(factorial(2), equalTo(2L));
        assertThat(factorial(9), equalTo(362880L));

        assertThat(factorialIterative(1), equalTo(1L));
        assertThat(factorialIterative(0), equalTo(1L));
        assertThat(factorialIterative(2), equalTo(2L));
        assertThat(factorialIterative(9), equalTo(362880L));

        assertThat(factorialIteStream(1), equalTo(1L));
        assertThat(factorialIteStream(0), equalTo(1L));
        assertThat(factorialIteStream(2), equalTo(2L));
        assertThat(factorialIteStream(9), equalTo(362880L));

        assertThat(factorialTailRec(1, 1), equalTo(1L));
        assertThat(factorialTailRec(0, 1), equalTo(1L));
        assertThat(factorialTailRec(2, 1), equalTo(2L));
        assertThat(factorialTailRec(9, 1), equalTo(362880L));

        assertThat(factorialTailToIterative(3), equalTo(6L));
    }


    private long factorial(long n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    private long factorialTailRec(long n, long acc) {
        if (n <= 1) return acc;
        return factorialTailRec(n - 1, acc * n);
    }

    private long factorialTailToIterative(long n) {
        long acc2 = 1;
        for (long i = n; i > 1; i--) {
            acc2 = acc2 * i;
        }
        return acc2;
    }


    private long factorialIterative(long n) {
        long res = 0;

        for (long i = 0; i <= n; i++) {
            res = (i <= 1) ? 1 : res * i;
        }
        return res;
    }

    private class Topple {
        final long v1;
        final long v2;

        Topple(long v1, long v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
    }

    private long factorialIteStream(long n) {
        return LongStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b);
    }


}
