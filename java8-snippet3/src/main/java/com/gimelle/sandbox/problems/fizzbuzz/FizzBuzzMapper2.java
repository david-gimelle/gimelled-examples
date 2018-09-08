package com.gimelle.sandbox.problems.fizzbuzz;

import java.util.Optional;

public class FizzBuzzMapper2 {

    public static Optional<String> map(int i) {

        if (i<1) return Optional.empty();
        if (i%3 == 0 && i%5 == 0) return Optional.of("FizzBuzz");
        if (i%3 == 0) return Optional.of("Fizz");
        if (i%5 == 0) return Optional.of("Buzz");

        return Optional.of(String.valueOf(i));
    }
}
