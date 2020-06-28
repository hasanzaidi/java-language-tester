package org.hasan;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class ArrayListTest {
    @Test(expected = IndexOutOfBoundsException.class)
    public void testCantAddAtArbitraryIndexes() {
        List<String> myList = new ArrayList<>();
        myList.add(3, "a");
    }

    @Test
    public void testConvertToArray() {
        List<String> fruits = new ArrayList<>();
        fruits.add("Orange");
        fruits.add("Apple");
        fruits.add("Banana");

        String[] arr = fruits.toArray(new String[fruits.size()]);

        assertThat(arr, is(new String[] {"Orange", "Apple", "Banana"}));
    }
}
