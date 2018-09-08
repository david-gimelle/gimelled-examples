package com.gimelle.sandbox.functional;


import java.util.function.Supplier;

@FunctionalInterface
public interface CoolSupplier extends Supplier<String>{

     String get();

     default String random() {return "";}

}
