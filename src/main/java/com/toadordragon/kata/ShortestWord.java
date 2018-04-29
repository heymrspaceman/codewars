package com.toadordragon.kata;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ShortestWord {

    public static int findShort(String s) {
        return Arrays.asList(s.split(" "))
                .stream().map(a -> a.length() > 0 ? a.length() : Integer.MAX_VALUE).collect(Collectors.toList())
                .stream().min(Integer::compare).get();
    }
}
