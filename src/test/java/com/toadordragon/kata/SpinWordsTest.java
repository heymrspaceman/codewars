package com.toadordragon.kata;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SpinWordsTest {

    private SpinWords textProcessor;

    @Before
    public void setUp() {
        textProcessor = new SpinWords();
    }

    @Test
    public void shouldNotSpinStringOfLengthOne() {
        assertThat(textProcessor.spinWords("a"), is("a"));
    }

    @Test
    public void shouldNotSpinStringOfLengthTwo() {
        assertThat(textProcessor.spinWords("ab"), is("ab"));
    }

    @Test
    public void shouldNotSpinStringOfLengthFive() {
        assertThat(textProcessor.spinWords("abcde"), is("abcde"));
    }

    @Test
    public void shouldSpinStringOfLengthSix() {
        assertThat(textProcessor.spinWords("abcdef"), is("fedcba"));
    }

    @Test
    public void shouldSpinStringOfLengthSeven() {
        assertThat(textProcessor.spinWords("abcdefg"), is("gfedcba"));
    }

    @Test
    public void shouldSpinFirstStringWhenWholeStringSeparatedByWhitespace() {
        assertThat(textProcessor.spinWords("a abcdef"), is("a fedcba"));
    }

    @Test
    public void shouldSpinSecondStringWhenWholeStringSeparatedByWhitespace() {
        assertThat(textProcessor.spinWords("abcdef a"), is("fedcba a"));

    }
}
