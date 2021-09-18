package org.hasan.java14;

import org.junit.jupiter.api.Test;

import static java.util.Calendar.FRIDAY;
import static java.util.Calendar.MONDAY;
import static java.util.Calendar.SATURDAY;
import static java.util.Calendar.SUNDAY;
import static java.util.Calendar.THURSDAY;
import static java.util.Calendar.TUESDAY;
import static java.util.Calendar.WEDNESDAY;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Java14Test {
    @Test
    public void testSwitchExpression() {
        int day = MONDAY;

        int numLetters = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
            default -> 0;
        };

        assertThat(numLetters, is(6));
    }

    @Test
    public void testRecord() {
        Point p = new Point(1, 2);
        assertThat(p.x(), is(1));
        assertThat(p.y(), is(2));
    }
}
