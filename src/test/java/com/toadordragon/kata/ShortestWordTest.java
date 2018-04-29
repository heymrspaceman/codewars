package com.toadordragon.kata;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShortestWordTest {

    private ShortestWord sentence;

    @Before
    public void setUp() {
        sentence = new ShortestWord();
    }

    @Test
    public void shouldSentenceWithOneLetterWordReturn1() {
        assertThat(sentence.findShort("a"), is(1));
    }

    @Test
    public void shouldSentenceWithTwoLetterWordReturn2() {
        assertThat(sentence.findShort("ab"), is(2));
    }

    @Test
    public void shouldSentenceWithThreeLetterWordReturn3() {
        assertThat(sentence.findShort("abc"), is(3));
    }

    @Test
    public void shouldSentenceWithTwoIdenticalWordsReturnShortestWordLength() {
        assertThat(sentence.findShort("a a"), is(1));
    }

    @Test
    public void shouldSentenceWithNonIdenticalWordsReturn2() {
        assertThat(sentence.findShort("ab abc"), is(2));
    }

    @Test
    public void shouldSentenceWithNonIdenticalWordsReturn3() {
        assertThat(sentence.findShort("abc abcd"), is(3));
    }

    @Test
    public void shouldSentenceWithExtraWhitespaceReturnCorrectResult() {
        assertThat(sentence.findShort("this  sentence"), is(4));
    }
}
