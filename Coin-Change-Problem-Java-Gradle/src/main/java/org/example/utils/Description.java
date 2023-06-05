package org.example.utils;

public class Description {
    private int sum;
    private int[] coinTypeArray;

    public Description(int sum, int[] coinTypeArray) {
        this.sum = sum;
        this.coinTypeArray = coinTypeArray;
    }

    public int getSum() {
        return sum;
    }

    public int[] getCoinTypeArray() {
        return coinTypeArray;
    }
}

