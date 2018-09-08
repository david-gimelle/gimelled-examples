package com.gimelle.sandbox.functional;

@FunctionalInterface
public interface GenericFT<T> {

    T apply(T t);
}
