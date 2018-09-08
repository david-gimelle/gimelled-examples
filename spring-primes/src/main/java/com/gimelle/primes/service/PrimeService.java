package com.gimelle.primes.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PrimeService {

    private Logger logger = LoggerFactory.getLogger(PrimeService.class);

    public List<Integer> primes(Integer maxInt, Optional<String> algo) {
        logger.debug("maxInt {}, Algo {}", maxInt, algo);

        AlgoName algoName = AlgoName.valueOf(algo.orElse(AlgoName.half.name()));


        IntStream rangeClosed = IntStream.rangeClosed(2, maxInt);
        return rangeClosed
                .filter(n -> n == 2 || n%2 != 0) //remove the even numbers but 2
                .filter(this.isAPrime()::test)
                .boxed()
                .collect(Collectors.toList());
    }

    public Predicate<Integer> isAPrime(){
        return number -> IntStream
                .rangeClosed(2, number/2)
                .noneMatch(i -> number%i == 0);
    }



}
