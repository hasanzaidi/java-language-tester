package org.hasan;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayListTest {
    @Test
    void testCantAddAtArbitraryIndexes() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            List<String> myList = new ArrayList<>();
            myList.add(3, "a");
        });
    }

    @Test
    void testConvertToArray() {
        List<String> fruits = List.of("Orange", "Apple", "Banana");

        String[] arr = fruits.toArray(new String[fruits.size()]);

        assertThat(arr, is(new String[] {"Orange", "Apple", "Banana"}));
    }
}
