package com.gimelle.sandbox.problems;

import com.gimelle.sandbox.problems.vending.VendingMachine;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class VendingMachineTest {


    /*
    * A vending machine return some cash coins. The possible coins are [100,
50, 20, 10, 5, 2, 1].

Minimum class required:

a class VendingMachine with a method

int[] transaction(int price, int moneyIn) that return an arrays of the
coins returned

a VendingMachineTest class to instance your machine and test it.

Use Java 8, mvn, and any unit test framework you like. Keep it TTD and simple.

1 - Create a vending machine that return the less possible coins for
any transactions

For example if the amountToPay is 250, I put 500, it should return [100,100,50]

2 - Add a stock of coins in the vending machine (initialy only 10
coins of each). If no coins available an empty array is retuned

For example if if the amountToPay is 250, I put 500, it should return
[100,100,50] and the vending machin should have only 8 “100” coins and
9 “50” coins

3 - Let’s pay also with coins too

For example if the amountToPay is 175 and I pay [100, 100], the
machine will return [20,5] and will have 12 “100” coins, 9 “20” and 9
“5”*/

    List<Integer> possibleCoins = Arrays.asList(5, 2, 1);
    VendingMachine machine;

    @Before
    public void init(){
        machine = new VendingMachine(possibleCoins, 3);
    }

    @Test
    public void noCoinsReturnedForNothingPaid(){

        assertThat(
                machine.transaction(0, Collections.EMPTY_LIST),
                equalTo(Collections.EMPTY_SET)
        );
    }

    @Test
    public void returnSmallCoins(){

        assertThat(
                machine.transaction(1,Collections.singletonList(0)),
                equalTo(Collections.EMPTY_SET)
        );

        assertThat(
                machine.transaction(2,Collections.singletonList(5)),
                equalTo(Arrays.asList(2, 1).stream().collect(Collectors.toSet()))
        );

    }

    @Test
    public void returnSmallCoinsEdgeCase(){

        assertThat(
                machine.transaction(0,Collections.singletonList(0)),
                equalTo(Collections.EMPTY_SET)
        );


    }

    @Test
    public void smallCoinsCheck() {
        assertThat(
                machine.getTills().get(1),
                equalTo(3)
        );

        assertThat(
                machine.getTills().get(2),
                equalTo(3)
        );

        assertThat(
                machine.getTills().get(5),
                equalTo(3)
        );

        assertThat(
                machine.transaction(2, Collections.singletonList(5)),
                equalTo(Arrays.asList(2, 1).stream().collect(Collectors.toSet()))
        );

        assertThat(
                machine.getTills().get(1),
                equalTo(2)
        );

        assertThat(
                machine.getTills().get(2),
                equalTo(2)
        );

        assertThat(
                machine.getTills().get(5),
                equalTo(4)
        );

    }

    //TODO had some smarter change edge case. One with lot of coins in. One with exaustion of 1£ coins

    //TODO: Check for wrong coins like the ones with value Zero or 42!
    //TODO: Not enough change to sendback! In real life, the machine keep the change !!! Or at best next customer has a discount!

}
