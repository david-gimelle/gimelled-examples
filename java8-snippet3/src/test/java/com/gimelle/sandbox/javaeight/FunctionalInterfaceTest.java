package com.gimelle.sandbox.javaeight;

import com.gimelle.sandbox.functional.*;
import org.junit.Test;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/*
All inspired by http://www.java2s.com/Tutorials/Java/Java_Lambda/0030__Java_Lambda_Syntax.htm
* */
public class FunctionalInterfaceTest {

    @Test
    public void basicDefinition(){

        //Custom example
        AddingFuncInterface add = (i1, i2) -> Integer.sum(i1, i2);

        assertThat(add.addSome(2,2), equalTo(4));

        BooleanSupplier bs = () -> true;

        //Some other example
        //Function
        Function<String, Integer> functionOne = s1 -> s1.length();
        assertThat(functionOne.apply("t0t0"),equalTo(4));

        //UnaryOperator
        UnaryOperator<String> unaryOperatorOne = s1 -> s1.toLowerCase();
        assertThat(unaryOperatorOne.apply("Toto"), equalTo("toto"));

        //Supplier
        Supplier<String> supplierOne = () -> "Toto";
        assertThat(supplierOne.get(),equalTo("Toto"));

        //Predicate
        Predicate<String> predicateOne = s1 -> s1.isEmpty();
        assertThat(predicateOne.test("Toto"), is(false));

        //Consumer
        Consumer<String> consumOne = s1 -> System.out.println(s1);
        consumOne.accept("Toto is the best");

        //BinaryOperator
        BinaryOperator<String> binOp = (s1, s2) -> s1.concat(s2);
        assertThat(binOp.apply("Ta","ti"),equalTo("Tati"));
    }

    @Test
    public void funnyInterfacesDeclaration(){

        CoolSupplier cs = () -> "Cool!";

        assertThat(cs.get(), equalTo("Cool!"));

        GenericFT<Long> gft = l1 -> l1 + 1;

        NonGenericFT ngft = new NonGenericFT() {
            @Override
            public <T> T gene(T t) {
                return t;
            }
        }; // No other way to instance it! ??


        assertThat(gft.apply(1L), equalTo(2L));
        assertThat(ngft.gene(1L), equalTo(1L));
    }


    @Test
    public void intersectionOfInterfaces_TerrificOrTerrible(){
        java.io.Serializable ss = (Serializable & CoolSupplier) () -> "SoCoolAndSerialisable";
        assertThat(((CoolSupplier) ss).get(), equalTo("SoCoolAndSerialisable"));
    }

    @Test
    public void exploringFunctionInterface(){

        Function<String, Long> f1 = str -> (long) str.length();

        UnaryOperator<Long> ll = l -> l;

        Predicate<Long> pp =  (final Long l) -> l>0;

        assertThat(f1.apply("toto"), equalTo(4L));
        //https://stackoverflow.com/questions/28032827/java-8-lambdas-function-identity-or-t-t

        assertThat(Function.identity().apply(8L), equalTo(ll.apply(8L)));

    }

    static IntFunction<Integer> factorial2 = (int e) -> e == 0
            ? 1 : e * FunctionalInterfaceTest.factorial2.apply(e-1);

    @Test
    public void exploringRecurcivityWithLambda(){

        IntFunction factorial = Maths::factor;

        assertThat(factorial.apply(0), equalTo(1));
        assertThat(factorial.apply(4), equalTo(24));


        assertThat(factorial2.apply(4), equalTo(24));
    }

    @Test
    public void exploringLambdaVariableCapture(){

        String x = "1";

        BiFunction<String,String,String> addSome = (s1, s2) -> s1 + x + s2;


        assertThat(addSome.apply("a","b"), equalTo("a1b"));

        Function<String[],List<String>> asList = Arrays::<String>asList;

        System.out.println(asList.apply(new String[]{"a","b","c"}));

    }


}
