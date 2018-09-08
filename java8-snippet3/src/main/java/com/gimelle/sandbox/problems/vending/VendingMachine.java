package com.gimelle.sandbox.problems.vending;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.EMPTY_SET;

public class VendingMachine {

    private final List<Integer> possibleCoins;
    private final Map<Integer, Integer> tillChange;

    public VendingMachine(List<Integer> possibleCoins, int initSize) {
        this.possibleCoins = possibleCoins;
        tillChange = possibleCoins
                .stream()
                .collect(
                        Collectors.toMap(Function.identity(), s -> initSize)
                );
    }

    public Map<Integer, Integer> getTills() {
        return tillChange;
    }

    /*@return minimum coins in order bigger first*/
    public Set<Integer> transaction(int price, List<Integer> moneyIn) {
        if (moneyIn.isEmpty() || (moneyIn.stream().reduce((x,y)-> x+y).get() - price) <= 0) {
            return Collections.EMPTY_SET;
        } else {
            return calculateChange(price, moneyIn);
        }
    }


    private Set<Integer> calculateChange(int price, List<Integer> moneyIn) {

        Set<Integer> coins = new HashSet<>();

        int remaining = moneyIn.stream().reduce((x,y)-> x+y).get() - price;

        moneyIn.forEach(c -> {
            System.out.println("c>>"+c);
            System.out.println("Existing one>"+tillChange.get(c));
            tillChange.replace(c, tillChange.get(c)+1);
        });

        for (Integer coinValue : possibleCoins) {

            int numberOfCoins = remaining / coinValue;

            if (numberOfCoins > 0) {
                coins.addAll(
                        IntStream.rangeClosed(1, numberOfCoins)
                                .mapToObj(n -> coinValue)
                                .collect(Collectors.toSet())
                );
                tillChange.replace(coinValue, tillChange.get(coinValue) - numberOfCoins);
                remaining = remaining - (coinValue * numberOfCoins);
            }
        }

        return coins;
    }
}
