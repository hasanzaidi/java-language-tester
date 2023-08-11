package org.hasan.java16;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

class Java16Test {
    @Test
    void testPatternMatching() {
        // With pattern matching, can assign object to String without any casting
        Object myObject = "ORANGE";
        if (myObject instanceof String myString) {
            assertThat(myString.toLowerCase(Locale.ROOT), is("orange"));
        }
    }

    @Test
    void toList() {
        List<Integer> numbers = List.of(1, 2, 3).stream().toList();
        assertThat(numbers, contains(1, 2, 3));
    }

    @Test
    void toListIsImmutable() {
        List<Integer> numbers = List.of(1, 2, 3).stream().toList();
        assertThatThrownBy(() -> numbers.add(4))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
