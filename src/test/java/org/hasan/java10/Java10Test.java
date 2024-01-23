package org.hasan.java10;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Java10Test {
    @Test
    void testVarKeyword() {
        var myString = "hello world";
        assertThat(myString).isEqualTo("hello world");
    }

    @Test
    void testCopyOf() {
        // Given:
        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);

        // When:
        // copyOf should only be used on a modifiable ArrayList
        List<Integer> myUnmodifiableCopy = List.copyOf(myList);

        // Then:
        assertThat(myList).hasSize(2);
        assertThat(myUnmodifiableCopy).hasSize(2);
    }
}
