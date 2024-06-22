package org.hasan.java8;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class FunctionalInterfaceTest {
    @Test
    void testSquare() {
        // Given:
        Calculator square = (int x) -> x * x;

        // When:
        int value = square.calculate(5);

        // Then:
        assertThat(value).isEqualTo(25);
    }
}
