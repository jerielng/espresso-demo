package com.ncr.espressodemo.Utilities;

public class NumberCounter {

    private int number;

    public NumberCounter() {
        number = 0;
    }

    public void increment() {
        number++;
    }

    public void decrement() {
        number--;
    }

    public int getNumber() {
        return number;
    }
}
