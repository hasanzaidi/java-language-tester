package org.hasan.java8;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OptionalsTest {
    @Test
    void optionalClass() {
        Optional<String> version = Optional.ofNullable("2.0");
        assertThat(version.isPresent(), is(true));
        assertThat(version.orElse("1.0"), is("2.0"));

        Optional<String> version2 = Optional.ofNullable(null);
        assertThat(version2.isPresent(), is(false));
        assertThat(version2.orElse("1.0"), is("1.0"));

        // A non-nullable option will throw an exception
        try {
            Optional.of(null);
            assertTrue(false);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
    }
}
