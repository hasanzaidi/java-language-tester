package org.hasan.java8;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class FunctionTest {
    @Test
    void testFunction() {
        // Given:
        // Creates a function which takes a String and returns an Integer (using a Method reference)
        Function<String, Integer> length = String::length;

        // When:
        Integer result = length.apply("Hello World");

        // Then:
        assertThat(result, is(11));
    }
}
