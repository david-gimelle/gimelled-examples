H) Hotel.com - Vending Machine

A vending machine return some cash coins. The possible coins are [100,
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
“5”