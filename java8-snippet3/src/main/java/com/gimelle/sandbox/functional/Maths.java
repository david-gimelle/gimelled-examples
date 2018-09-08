package com.gimelle.sandbox.functional;

public class Maths {

    public static int factor(int f){
        return f == 0 ? 1 : f * factor(f-1);
    }
}
