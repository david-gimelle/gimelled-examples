package com.gimelle.primes.service;

import java.util.function.Predicate;

public enum AlgoName {
    old(PrimesAlgosUtils.isAPrimeSq()),
    half(PrimesAlgosUtils.isAPrimeSq()),
    sq(PrimesAlgosUtils.isAPrimeSq());

    private final Predicate<Integer> function;


    AlgoName(Predicate<Integer> function) {
        this.function = function;
    }

}
