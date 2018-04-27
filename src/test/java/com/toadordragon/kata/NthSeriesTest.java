package com.toadordragon.kata;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class NthSeriesTest {

    private NthSeries nth;

    @Before
    public void setUp() {
        nth = new NthSeries();
    }

    @Test
    public void shouldNthSeriesOneReturnCorrectResult() {
        assertThat(nth.sumSeries(1), is("1.00"));
    }

    @Test
    public void shouldNthSeriesTwoReturnCorrectResult() {
        assertThat(nth.sumSeries(2), is("1.25"));
    }

    @Test
    public void shouldNthSeriesThreeReturnCorrectResult() {
        assertThat(nth.sumSeries(3), is("1.39"));
    }

    @Test
    public void shouldNthSeriesFiveReturnCorrectResult() {
        assertThat(nth.sumSeries(6), is("1.57"));
    }

    @Test
    public void shouldNthSeriesZeroReturnCorrectResult() {
        assertThat(nth.sumSeries(0), is("0.00"));
    }
}
