package org.hasan.java8;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

// Consumers accept arguments but do not return a result.
class ConsumerTest {
    @Test
    void testConsumerSingleArg() {
        // Given:
        // Creates a function which takes a Date
        Consumer<LocalDate> printYear = date -> System.out.println(date.getYear());

        // When/Then:
        printYear.accept(LocalDate.of(2020, 12, 13));
    }

    @Test
    void testConsumerTwoArgs() {
        // Given:
        // Creates a function which takes a Date
        BiConsumer<LocalDate, String> printYearSuffix = (date, suffix) -> System.out.println(date.getYear() + suffix);

        // When/Then:
        printYearSuffix.accept(LocalDate.of(2020, 12, 13), "a");
    }
}
