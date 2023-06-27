package org.hasan.java8;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// Functions accept arguments and return a result
class FunctionTest {
    @Test
    void testFunctionSingleArg() {
        // Given:
        // Creates a function which takes a String and returns an Integer (using a Method reference)
        Function<String, Integer> length = String::length;

        // When:
        Integer result = length.apply("Hello World");

        // Then:
        assertThat(result, is(11));
    }

    @Test
    void testFunctionTwoArgs() {
        // Given:
        // Creates a function which takes two Strings and returns an Integer
        BiFunction<String, String, Integer> length = (s1, s2) -> s1.length() + s2.length();

        // When:
        Integer result = length.apply("Hello", "World");

        // Then:
        assertThat(result, is(10));
    }

    @Test
    void testComposition() {
        // Given:
        Function<Integer, String> convertToString = String::valueOf;
        Function<String, String> appendDot = s -> s + ".";

        // When:
        String result = convertToString
                .andThen(appendDot)
                .apply(123);

        // Then:
        assertThat(result, is("123."));
    }
}
