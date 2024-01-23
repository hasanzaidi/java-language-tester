package org.hasan.java8;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static org.assertj.core.api.Assertions.assertThat;

class LambdasTest {
    @Test
    void sorting() {
        String[] words = {"aaa", "b", "cccc", "dd"};
        Arrays.sort(words, (String s1, String s2) -> s1.length() - s2.length());
        assertThat(words).isEqualTo(new String[]{"b", "dd", "aaa", "cccc"});
    }

    @Test
    void filtering() {
        List<String> vals = List.of("x", "a", "m", "a", "x");
        long countOfAs = vals.stream().filter(v -> v.equals("a")).count();
        assertThat(countOfAs).isEqualTo(2L);

        List<String> nonAs = vals.stream().filter(v -> !v.equals("a")).toList();
        assertThat(nonAs).isEqualTo(List.of("x", "m", "x"));
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
        assertThat(nonNulls).isEqualTo(List.of("x", "y"));
    }

    @Test
    void groupInToMap() {
        List<String> vals = List.of("x", "a", "m", "a", "x");
        Map<String, Long> valCount = vals.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        assertThat(valCount.get("x")).isEqualTo(2L);
        assertThat(valCount.get("m")).isEqualTo(1L);
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
        assertThat(upper).containsExactly("APPLE", "BANANA", "STRAWBERRY");

        // Get the smallest String in the list
        int minStringLength = fruits.stream().mapToInt(s -> s.length()).min().getAsInt();
        assertThat(minStringLength).isEqualTo(5);
    }

    @Test
    void minMaxValues() {
        List<Integer> numbers = List.of(2, 1, 9, 4, 8);

        int max = numbers.stream().max(Integer::compare).get();
        assertThat(max).isEqualTo(9);

        int min = numbers.stream().min(Integer::compare).get();
        assertThat(min).isEqualTo(1);
    }

    @Test
    void reduce() {
        List<Integer> numbers = List.of(1, 2, 5, 2);
        int total = numbers.stream().reduce((x, y) -> x + y).get();
        assertThat(total).isEqualTo(10);
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
        assertThat(combinedList).isEqualTo(List.of(1, 4, 10, 20, 30, 5, 15));
    }

    @Test
    void teeing() {
        // Given:
        List<Integer> numbers = List.of(1, 5, 10, 6);

        // When:
        Map<String, Integer> result = numbers.stream().collect(
                Collectors.teeing(
                        minBy(Integer::compareTo),
                        maxBy(Integer::compareTo),
                        (e1, e2) -> {
                            Map<String, Integer> map = new HashMap();
                            map.put("MIN", e1.get());
                            map.put("MAX", e2.get());
                            return map;
                        }
                ));

        // Then:
        assertThat(result.get("MAX")).isEqualTo(10);
        assertThat(result.get("MIN")).isEqualTo(1);
    }
}
