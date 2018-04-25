package com.toadordragon.kata;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SpinWords {
    public String spinWords(String sentence) {
        return Arrays.asList(sentence.split(" ")).stream().map(w -> spinSingleString(w)).collect(Collectors.joining(" "));
    }

    private String spinSingleString(String sentence) {
        String spinnedSentence = "";

        if (sentence.length() <= 5) {
            spinnedSentence = sentence;
        } else {
            for (int i = sentence.length() - 1; i >= 0; i--) {
                spinnedSentence = spinnedSentence + sentence.charAt(i);
            }
        }
        return spinnedSentence;
    }
}
