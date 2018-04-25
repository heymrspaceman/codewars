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
}
