package org.hasan.java8;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

// Predicates accept arguments to test against an expression and return a boolean result
class PredicateTest {
    @Test
    void testPredicateSingleArg() {
        // Given:
        List<Integer> vals = List.of(1, 8, 9, 20);

        // When:
        Predicate<Integer> greaterThanEight = value -> value > 8;
        List<Integer> numbersArr = vals.stream().filter(greaterThanEight).toList();

        // Then:
        assertThat(numbersArr).isEqualTo(List.of(9, 20));
    }

    @Test
    void testPredicateTwoArgs() {
        // Given/When:
        BiPredicate<Integer, Integer> greaterThanN = (value, comp) -> value > comp;

        // Then:
        assertThat(greaterThanN.test(9, 8)).isTrue();
        assertThat(greaterThanN.test(8, 8)).isFalse();
        assertThat(greaterThanN.test(8, 9)).isFalse();
    }

    @Test
    void testPrimitivePredicate() {
        IntPredicate oddNumbers = val -> val % 2 == 1;

        int[] numbersArr = IntStream.range(1, 10).filter(oddNumbers).toArray();
        assertThat(numbersArr).isEqualTo(new int[] {1, 3, 5, 7, 9});

        List<Integer> numbersColl = IntStream.range(1, 10).filter(oddNumbers).boxed().toList();
        assertThat(numbersColl).containsExactly(1, 3, 5, 7, 9);
    }
}
