package org.hasan.java8;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// Suppliers don't accept arguments but return a result
class SupplierTest {
    @Test
    void testSupplier() {
        // Given:
        Supplier<Double> two = () -> 2.0;

        // When:
        Double result = two.get();

        // Then:
        assertThat(result, is(2.0));
    }
}
