package org.hasan.java8;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class PredicateTest {
    @Test
    void streamSequenceOfValues() {
        IntPredicate oddNumbers = val -> val % 2 == 1;

        // Creating an array
        int[] numbersArr = IntStream.range(1, 10).filter(oddNumbers).toArray();
        assertThat(numbersArr, is(new int[] {1, 3, 5, 7, 9}));

        // Creating a List
        List<Integer> numbersColl = IntStream.range(1, 10).filter(oddNumbers).boxed().collect(toList());
        assertThat(numbersColl, is(List.of(1, 3, 5, 7, 9)));
    }

    @Test
    void testPredicate() {
        // Given:
        List<Integer> vals = List.of(1, 8, 9, 20);

        // When:
        Predicate<Integer> greaterThanEight = value -> value > 8;
        List<Integer> numbersArr = vals.stream().filter(greaterThanEight).toList();

        // Then:
        assertThat(numbersArr, is(List.of(9, 20)));
    }
}
