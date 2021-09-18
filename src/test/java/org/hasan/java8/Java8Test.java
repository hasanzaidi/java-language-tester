package org.hasan.java8;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Java8Test {
    @Test
    public void streamSequenceOfValues() {
        IntPredicate oddNumbers = val -> val % 2 == 1;

        // Creating an array
        int[] numbersArr = IntStream.range(1, 10).filter(oddNumbers).toArray();
        assertThat(numbersArr, is(new int[] {1, 3, 5, 7, 9}));

        // Creating a List
        List<Integer> numbersColl = IntStream.range(1, 10).filter(oddNumbers).boxed().collect(toList());
        assertThat(numbersColl, is(List.of(1, 3, 5, 7, 9)));
    }

    @Test
    public void optionalClass() {
        Optional<String> version = Optional.ofNullable("2.0");
        assertThat(version.isPresent(), is(true));
        assertThat(version.orElse("1.0"), is("2.0"));

        Optional<String> version2 = Optional.ofNullable(null);
        assertThat(version2.isPresent(), is(false));
        assertThat(version2.orElse("1.0"), is("1.0"));

        // A non-nullable option will throw an exception
        try {
            Optional.of(null);
            assertTrue(false);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
    }
}
