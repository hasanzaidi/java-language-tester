package org.hasan.java8;

import org.junit.jupiter.api.Test;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OptionalsTest {
    // Use "of" if value is definitely not null
    @Test
    void testOf() {
        Optional<String> version = Optional.of("2.0");
        assertThat(version.isPresent()).isTrue();
        assertThat(version.get()).isEqualTo("2.0");
        assertThat(version.orElse("1.0")).isEqualTo("2.0");

        // A non-nullable option will throw an exception
        try {
            Optional.of(null);
            assertTrue(false);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
    }

    // Use "ofNullable" if value may be null
    @Test
    void testOfNullable() {
        Optional<String> version = Optional.ofNullable("2.0");
        assertThat(version.isPresent()).isTrue();
        assertThat(version.orElse("1.0")).isEqualTo("2.0");

        Optional<String> version2 = Optional.ofNullable(null);
        assertThat(version2.isPresent()).isFalse();
        assertThat(version2.orElse("1.0")).isEqualTo("1.0");
    }

    // Use "ofNullable" if value may be null
    @Test
    void testEmpty() {
        Optional<String> version = Optional.empty();
        assertThat(version.isPresent()).isFalse();
    }
}
