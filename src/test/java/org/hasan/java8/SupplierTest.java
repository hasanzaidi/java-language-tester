package org.hasan.java8;

import org.junit.jupiter.api.Test;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

// Suppliers don't accept arguments but return a result
class SupplierTest {
    @Test
    void testSupplier() {
        // Given:
        Supplier<Double> two = () -> 2.0;

        // When:
        Double result = two.get();

        // Then:
        assertThat(result).isEqualTo(2.0);
    }

    @Test
    void testSupplierLazy() {
        // Given:
        IntSupplier two = () -> 2;
        // If this is executed then it would throw an exception
        IntSupplier divisionByZero = () -> 1/0;

        // When:
        int result = add(two, divisionByZero);

        // Then:
        assertThat(result).isEqualTo(2);
    }

    // Supplies are lazily evaluated so "unusedSupplier" is never executed as "getAsInt" is never called for it
    private int add (IntSupplier supplier1, IntSupplier unusedSupplier) {
        var actualX = supplier1.getAsInt();
        return actualX;
    }
}
