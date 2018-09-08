package com.gimelle.sandbox.problems.fibo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FiboCalculator {

    public static List<Long> generates(int lengh) {

        if (lengh <= 2)
            return Arrays.asList(1L, 1L);
        else
            return fibos(lengh, new ArrayList<>());
    }

    public static List<Long> fibos(int lengh, List<Long> acc) {

        if (lengh == 1) return Arrays.asList(1L);
        if (lengh == 2) return Arrays.asList(1L, 1L);

        return IntStream
                .rangeClosed(1, lengh)
                .mapToObj(x -> fibo(x))
                .collect(Collectors.toList());
    }

    public static Long fibo(int n) {
        if (n <= 0) return 0L;
        if (n == 1) return 1L;
        if (n == 2) return 1L;
        return fibo(n - 1) + fibo(n - 2);
    }
}
