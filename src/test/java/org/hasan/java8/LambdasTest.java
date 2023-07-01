package org.hasan.java8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class LambdasTest {
    @Test
    void sorting() {
        String[] words = {"aaa", "b", "cccc", "dd"};
        Arrays.sort(words, (String s1, String s2) -> s1.length() - s2.length());
        assertThat(words, is(new String[]{"b", "dd", "aaa", "cccc"}));
    }

    @Test
    void filtering() {
        List<String> vals = List.of("x", "a", "m", "a", "x");
        long countOfAs = vals.stream().filter(v -> v.equals("a")).count();
        assertThat(countOfAs, is(2L));

        List<String> nonAs = vals.stream().filter(v -> !v.equals("a")).toList();
        assertThat(nonAs, is(List.of("x", "m", "x")));
    }

    @Test
    void filteringNulls() {
        // Given:
        // Can't use List.of here because it does not allow nulls
        List<String> vals = new ArrayList<>();
        vals.add("x");
        vals.add(null);
        vals.add("y");

        // When:
        List<String> nonNulls = vals.stream().filter(Objects::nonNull).toList();

        // Then:
        assertThat(nonNulls, is(List.of("x", "y")));
    }

    @Test
    void groupInToMap() {
        List<String> vals = List.of("x", "a", "m", "a", "x");
        Map<String, Long> valCount = vals.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        assertThat(valCount.get("x"), is(2L));
        assertThat(valCount.get("m"), is(1L));
    }

    // Peek provides ability to debug stream
    @Test
    void mapFunction() {
        List<String> fruits = List.of("Banana", "Apple", "Strawberry");
        List<String> upper = fruits.stream()
                .map(v -> v.toUpperCase())
                .peek(f -> System.out.println(f))
                .sorted()
                .toList();
        assertThat(upper, is(List.of("APPLE", "BANANA", "STRAWBERRY")));

        // Get the smallest String in the list
        int minStringLength = fruits.stream().mapToInt(s -> s.length()).min().getAsInt();
        assertThat(minStringLength, is(5));
    }

    @Test
    void minMaxValues() {
        List<Integer> numbers = List.of(2, 1, 9, 4, 8);

        int max = numbers.stream().max(Integer::compare).get();
        assertThat(max, is(9));

        int min = numbers.stream().min(Integer::compare).get();
        assertThat(min, is(1));
    }

    @Test
    void reduce() {
        List<Integer> numbers = List.of(1, 2, 5, 2);
        int total = numbers.stream().reduce((x, y) -> x + y).get();
        assertThat(total, is(10));
    }

    @Test
    void flatMap() {
        // Given:
        List<Integer> a = List.of(1, 4);
        List<Integer> b = List.of(10, 20, 30);
        List<Integer> c = List.of(5, 15);

        // When:
        List<Integer> combinedList = Stream.of(a, b, c)
                .flatMap(list -> list.stream())
                .toList();

        // Then:
        assertThat(combinedList, is(List.of(1, 4, 10, 20, 30, 5, 15)));
    }
}
