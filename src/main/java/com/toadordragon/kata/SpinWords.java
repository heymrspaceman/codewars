package com.toadordragon.kata;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SpinWords {
    public String spinWords(String sentence) {
        return Arrays.asList(sentence.split(" ")).stream().map(SpinWords::spinSingleString).collect(Collectors.joining(" "));
    }

    private static String spinSingleString(String sentence) {
        String spinnedSentence = sentence;

        String before = "";
        String strippedSentence = sentence;
        String after = "";

        if (strippedSentence.startsWith("[") || (strippedSentence.startsWith("(")) || (strippedSentence.startsWith("<"))) {
            before = strippedSentence.substring(0, 1);
            strippedSentence = strippedSentence.substring(1, strippedSentence.length());
        }

        if (strippedSentence.endsWith("]") || (strippedSentence.endsWith(")")) || (strippedSentence.endsWith(">"))) {
            after = strippedSentence.substring(strippedSentence.length() - 1, strippedSentence.length());
            strippedSentence = strippedSentence.substring(0, strippedSentence.length() - 1);
        }

        if (strippedSentence.length() >= 5) {
            spinnedSentence = before + spinWord(strippedSentence) + after;
        }

        return spinnedSentence;
    }

    private static String spinWord(String word) {
        StringBuilder spinnedWord = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            spinnedWord.append(word.charAt(i));
        }
        return spinnedWord.toString();
    }
}
