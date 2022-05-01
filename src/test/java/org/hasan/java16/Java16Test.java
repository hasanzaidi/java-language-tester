package org.hasan.java16;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Java16Test {
    @Test
    public void testPatternMatching() {
        // With pattern matching, can assign object to String without any casting
        Object myObject = "ORANGE";
        if (myObject instanceof String myString) {
            assertThat(myString.toLowerCase(Locale.ROOT), is("orange"));
        }
    }
}
