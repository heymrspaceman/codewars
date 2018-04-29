package com.toadordragon.kata;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortTheOdd {
    public static int[] sortArray(int[] array) {
        IntStream odds = Arrays.stream(array).filter(i -> ((i % 2 == 1)))
                .boxed().sorted(Collections.reverseOrder())
                .collect(Collectors.toList())
                .stream().mapToInt(Integer::intValue);

        Stack<Integer> oddsStack = new Stack<>();
        oddsStack.addAll(odds.boxed().collect(Collectors.toList()));

        for (int i = 0; i < array.length; i++) {
            if ((array[i] % 2) == 1) {
                array[i] = oddsStack.pop();
            }
        }

        return array;
    }
}
