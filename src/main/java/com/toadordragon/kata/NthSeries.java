package com.toadordragon.kata;

public class NthSeries {
    public String sumSeries(int n) {
        double result = 0;
        double denominator = 1;

        for(int i = 0; i < n; i++) {
            result = result + 1/ denominator;
            denominator = denominator + 3;
        }

        return String.format("%.2f", result);
    }
}
