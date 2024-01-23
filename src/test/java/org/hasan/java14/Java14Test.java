package org.hasan.java14;

import org.junit.jupiter.api.Test;

import static java.util.Calendar.FRIDAY;
import static java.util.Calendar.MONDAY;
import static java.util.Calendar.SATURDAY;
import static java.util.Calendar.SUNDAY;
import static java.util.Calendar.THURSDAY;
import static java.util.Calendar.TUESDAY;
import static java.util.Calendar.WEDNESDAY;
import static org.assertj.core.api.Assertions.assertThat;

class Java14Test {
    @Test
    void testSwitchExpression() {
        int day = MONDAY;

        int numLetters = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
            default -> 0;
        };

        assertThat(numLetters).isEqualTo(6);
    }

    @Test
    void testRecord() {
        Point p = new Point(1, 2);
        assertThat(p.x()).isEqualTo(1);
        assertThat(p.y()).isEqualTo(2);

        Point p2 = new Point(1, 2);
        assertThat(p.equals(p2)).isTrue();

        Point p3 = new Point(4, 3);
        assertThat(p.equals(p3)).isFalse();
    }

    @Test
    void testRecordUsingLombokBuilder() {
        Point p1 = new Point(1, 2);
        Point p2 = Point.builder().x(1).y(2).build();
        assertThat(p1.x()).isEqualTo(p2.x());
        assertThat(p1.y()).isEqualTo(p2.y());
    }
}
