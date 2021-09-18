package org.hasan;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

// Technically part of Java8Test but split out as it got quite big
public class LambdasTest {
    @Test
    public void sorting() {
        String[] words = {"aaa", "b", "cccc", "dd"};
        Arrays.sort(words, (String s1, String s2) -> s1.length() - s2.length());
        assertThat(words, is(new String[]{"b", "dd", "aaa", "cccc"}));
    }

    @Test
    public void filtering() {
        List<String> vals = Arrays.asList("x", "a", "m", "a", "x");
        long countOfAs = vals.stream().filter(v -> v.equals("a")).count();
        assertThat(countOfAs, is(2L));

        List<String> nonAs = vals.stream().filter(v -> !v.equals("a")).collect(toList());
        assertThat(nonAs, is(List.of("x", "m", "x")));
    }

    @Test
    public void groupInToMap() {
        List<String> vals = Arrays.asList("x", "a", "m", "a", "x");
        Map<String, Long> valCount = vals.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        assertThat(valCount.get("x"), is(2L));
        assertThat(valCount.get("m"), is(1L));
    }

    @Test
    public void mapFunction() {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Strawberry");
        List<String> upper = fruits.stream().map(v -> v.toUpperCase()).collect(toList());
        assertThat(upper, is(List.of("APPLE", "BANANA", "STRAWBERRY")));

        // Get the smallest String in the list
        int minStringLength = fruits.stream().mapToInt(s -> s.length()).min().getAsInt();
        assertThat(minStringLength, is(5));
    }

    @Test
    public void minMaxValues() {
        List<Integer> numbers = Arrays.asList(2, 1, 9, 4, 8);

        int max = numbers.stream().max(Integer::compare).get();
        assertThat(max, is(9));

        int min = numbers.stream().min(Integer::compare).get();
        assertThat(min, is(1));
    }

    @Test
    public void reduce() {
        List<Integer> numbers = Arrays.asList(1, 2, 5, 2);
        int total = numbers.stream().reduce((x, y) -> x + y).get();
        assertThat(total, is(10));
    }

    @Test
    public void flatMap() {
        // Given:
        List<Integer> a = Arrays.asList(1, 4);
        List<Integer> b = Arrays.asList(10, 20, 30);
        List<Integer> c = Arrays.asList(5, 15);

        // When:
        List<Integer> combinedList = Stream.of(a, b, c)
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        // Then:
        assertThat(combinedList, is(List.of(1, 4, 10, 20, 30, 5, 15)));
    }
}
