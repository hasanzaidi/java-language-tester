package org.hasan.java9;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Java9Test {
    @Test
    public void testCollectionFactoryMethods() {
        List<String> fruits = List.of("Apple", "Mango", "Banana");
        assertThat(fruits.get(0), is("Apple"));

        Set<String> fruitSet = Set.of("Apple", "Mango", "Banana");
        assertThat(fruitSet.contains("Apple"), is(true));
        assertThat(fruitSet.contains("strawberry"), is(false));

        Map<String, Integer> fruitMap = Map.of("Apple", 100, "Mango", 87, "Banana", 42);
        assertThat(fruitMap.get("Apple"), is(100));
    }
}
