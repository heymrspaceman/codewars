package com.toadordragon.kata;

import com.toadordragon.kata.SpinWords.SpinFile;
import com.toadordragon.kata.SpinWords.SpinWords;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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
        assertThat(textProcessor.processText("a"), is("a"));
    }

    @Test
    public void shouldNotSpinStringOfLengthTwo() {
        assertThat(textProcessor.processText("ab"), is("ab"));
    }

    @Test
    public void shouldSpinStringOfLengthFive() {
        assertThat(textProcessor.processText("abcde"), is("edcba"));
    }

    @Test
    public void shouldSpinStringOfLengthSix() {
        assertThat(textProcessor.processText("abcdef"), is("fedcba"));
    }

    @Test
    public void shouldSpinStringOfLengthSeven() {
        assertThat(textProcessor.processText("abcdefg"), is("gfedcba"));
    }

    @Test
    public void shouldSpinFirstStringWhenWholeStringSeparatedByWhitespace() {
        assertThat(textProcessor.processText("a abcdef"), is("a fedcba"));
    }

    @Test
    public void shouldSpinSecondStringWhenWholeStringSeparatedByWhitespace() {
        assertThat(textProcessor.processText("abcdef a"), is("fedcba a"));
    }

    @Test
    public void shouldSpinWordsTreatingSquareBracketsAsWhitespace() {
        assertThat(textProcessor.processText("<Just gniddik [ereht is llits] one more>"), is("<Just kidding [there is still] one more>"));
    }

    @Test
    public void shouldSpinWordsTreatingRoundBracketsAsWhitespace() {
        assertThat(textProcessor.processText("<Just gniddik (ereht is llits) one more>"), is("<Just kidding (there is still) one more>"));
    }

    @Test
    public void shouldSpinWordsToFromFile() {
        SpinFile input = Mockito.mock(SpinFile.class);
        SpinFile output = Mockito.mock(SpinFile.class);
        Mockito.when(input.read()).thenReturn("<Just gniddik (ereht is llits) one more time>");
        textProcessor.processFile(input, output);
        Mockito.verify(output, Mockito.times(1)).write("<Just kidding (there is still) one more time>");
    }
}
