package com.ncr.espressodemo.Utilities;

public class NumberCounter {

    private int number;

    public NumberCounter() {
        number = 1;
    }

    public void duplicate() {
        number += number;
    }

    public void decrement() {
        number--;
    }

    public int getNumber() {
        return number;
    }
}
