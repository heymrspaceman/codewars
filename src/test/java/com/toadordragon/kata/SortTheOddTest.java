package com.toadordragon.kata;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SortTheOddTest {

    private SortTheOdd numbers;

    @Before
    public void setUp()  {
        numbers = new SortTheOdd();
    }

    @Test
    public void shouldEmptyArrayReturnEmptyArray() {
        assertThat(numbers.sortArray(new int[]{}), is(new int[]{}));
    }

    @Test
    public void shouldNotSortSingleZero() {
        assertThat(numbers.sortArray(new int[]{0}), is(new int[]{0}));
    }

    @Test
    public void shouldNotSortSingleOddNumber() {
        assertThat(numbers.sortArray(new int[] {1}), is(new int[] {1}));
    }

    @Test
    public void shouldNotSortSingleEvenNumber() {
        assertThat(numbers.sortArray(new int[] {2}), is(new int[] {2}));
    }

    @Test
    public void shouldNotSortTwoSortedOddNumbersInArrayOfTwo() {
        assertThat(numbers.sortArray(new int[] {1, 3}), is(new int[] {1, 3}));
    }

    @Test
    public void shouldSortTwoSortedOddNumbersInArrayOfTwo() {
        assertThat(numbers.sortArray(new int[] {3, 1}), is(new int[] {1, 3}));
    }

    @Test
    public void shouldNotSortTwoUnsortedEvenNumbersInArrayOfTwo() {
        assertThat(numbers.sortArray(new int[] {4, 2}), is(new int[] {4, 2}));
    }

    @Test
    public void shouldSortNumbersEvenEvenOddToOddEvenEven() {
        assertThat(numbers.sortArray(new int[] {0, 2, 1}), is(new int[] {0, 2, 1}));
    }

    @Test
    public void shouldSortNumbersEvenOddEvenToOddEvenEven() {
        assertThat(numbers.sortArray(new int[] {0, 1, 0}), is(new int[] {0, 1, 0}));
    }

    @Test
    public void shouldSortDuplicateOddNumbersLeaveDuplicateEvenNumbers() {
        assertThat(numbers.sortArray(new int[] {0, 2, 0, 1, 3, 1, 3}), is(new int[] {0, 2, 0, 1, 1, 3, 3}));
    }

    @Test
    public void shouldSortOddNumbersInsertedInArray() {
        assertThat(numbers.sortArray(new int[]{ 5, 3, 2, 8, 1, 4 }), is(new int[] { 1, 3, 2, 8, 5, 4 }));
    }

    @Test
    public void shouldSortAscendingOddsNumbers() {
        assertThat(numbers.sortArray(new int[]{ 5, 3, 1, 8, 0 }), is(new int[] { 1, 3, 5, 8, 0 }));
    }
}
