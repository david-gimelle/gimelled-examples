package com.gimelle.sandbox.javaeight;

@FunctionalInterface
public interface NonGenericFT {

    <T> T gene(T t);
}
