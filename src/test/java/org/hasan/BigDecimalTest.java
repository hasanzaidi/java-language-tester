package org.hasan;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;

class BigDecimalTest {
    @Test
    void testInaccurateCalculations() {
        double amount1 = 2.15;
        double amount2 = 1.10;
        assertThat(1.05 == (amount1 - amount2)).isFalse();

        // Don't use the double constructor as that has the same problem as using doubles
        BigDecimal amount5 = new BigDecimal(2.15);
        BigDecimal amount6 = new BigDecimal(1.10);
        assertThat(1.05 == (amount5.subtract(amount6).doubleValue())).isFalse();
    }

    @Test
    void testAccurateCalculations() {
        // Instead use BigDecimal for financial calculation either with constructor...
        BigDecimal amount3 = new BigDecimal("2.15");
        BigDecimal amount4 = new BigDecimal("1.10");
        assertThat(1.05 == (amount3.subtract(amount4).doubleValue())).isTrue();

        // Or valueOf method
        BigDecimal amount5 = BigDecimal.valueOf(2.15);
        BigDecimal amount6 = BigDecimal.valueOf(1.10);
        assertThat(1.05 == (amount5.subtract(amount6).doubleValue())).isTrue();
    }
}
