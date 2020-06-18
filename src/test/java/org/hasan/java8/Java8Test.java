package org.hasan.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class Java8Test {
    @Test
    public void streamSequenceOfValues() {
        IntPredicate oddNumbers = val -> val % 2 == 1;
        IntStream range = IntStream.range(1, 10).filter(oddNumbers);
        assertThat(range.toArray(), is(new int[] {1, 3, 5, 7, 9}));
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
