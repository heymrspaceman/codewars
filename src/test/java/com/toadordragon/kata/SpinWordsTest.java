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
    public void shouldSpinStringOfLengthFive() {
        assertThat(textProcessor.spinWords("abcde"), is("edcba"));
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

    @Test
    public void shouldSpinWordsTreatingSquareBracketsAsWhitespace() {
        assertThat(textProcessor.spinWords("<Just gniddik [ereht is llits] one more>"), is("<Just kidding [there is still] one more>"));
    }

    @Test
    public void shouldSpinWordsTreatingRoundBracketsAsWhitespace() {
        assertThat(textProcessor.spinWords("<Just gniddik (ereht is llits) one more>"), is("<Just kidding (there is still) one more>"));
    }
}
