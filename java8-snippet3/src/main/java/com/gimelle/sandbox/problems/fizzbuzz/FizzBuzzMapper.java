package com.gimelle.sandbox.problems.fizzbuzz;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class FizzBuzzMapper {


    // What ever it's awful
    public static String fibuzOptional(int i) {
        Optional<String> res = Optional.of(i)
                .map(n ->
                        (n % 3 == 0 ? "Fizz" : "")
                                +
                                (n % 5 == 0 ? "Buzz" : "")
                );

        return res.get().equals("") ? "" + i : res.get();
    }

    public static String fibuzClassic(int i) {
        if ((i % 3 == 0) && (i % 5 == 0)) return "FizzBuzz";
        if (i % 3 == 0) return "Fizz";
        if (i % 5 == 0) return "Buzz";
        return i + "";
    }

    public static List<String> fibuzs(List<Integer> list) {
        return list
                .stream()
                .map(FizzBuzzMapper::fibuzOptional)
                .collect(Collectors.toList());
    }
}
