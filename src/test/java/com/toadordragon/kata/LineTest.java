package com.toadordragon.kata;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LineTest {

    private Line avengersLine;

    @Before
    public void setUp() {
        avengersLine = new Line();
    }

    @Test
    public void shouldHaveChangeForSinglePersonWithExactMoney() {
        assertThat(avengersLine.Tickets(new int[]{25}), is("YES"));
    }

    @Test
    public void shouldHaveNoChangeForSinglePersonRequiringTwentyFiveDollarBillChange() {
        assertThat(avengersLine.Tickets(new int[]{50}), is("NO"));
    }

    @Test
    public void shouldHaveNoChangeForSecondPersonRequiringFiftyDollarsBillChange() {
        assertThat(avengersLine.Tickets(new int[]{25, 75}), is("NO"));
    }

    @Test
    public void shouldHaveChangeForTwoPeopleWithExactMoney() {
        assertThat(avengersLine.Tickets(new int[]{25, 25}), is("YES"));
    }

    @Test
    public void shouldHaveNoChangeForThirdPersonRequiringSeventyFiveDollarsChange() {
        assertThat(avengersLine.Tickets(new int[]{25, 25, 100}), is("NO"));
    }

    @Test
    public void shouldHaveNoChangeWhenClerkHas100DollarBillAndPersonRequiring25Change() {
        assertThat(avengersLine.Tickets(new int[]{25, 25, 25, 100, 50}), is("NO"));
    }

    @Test
    public void shouldHaveChangeWhenClerkHas100DollarBillAndPersonRequiresNoChange() {
        assertThat(avengersLine.Tickets(new int[]{25, 25, 25, 100, 25}), is("YES"));
    }

    @Test
    public void shouldHaveChangeWhenClerkHas2x50And1x25With75ChangeRequired() {
        assertThat(avengersLine.Tickets(new int[]{25, 50, 25, 50, 25, 100}), is("YES"));
    }

    @Test
    public void shouldHaveChangeWhenClerkCanUse50InEarlier75ChangeWithRequiredWith25ChangeRequired() {
        assertThat(avengersLine.Tickets(new int[]{25, 25, 25, 25, 50, 100, 50}), is("YES"));
    }
}
