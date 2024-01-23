package org.hasan.java9;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class Java9Test {
    @Test
    void testCollectionFactoryMethods() {
        List<String> fruits = List.of("Apple", "Mango", "Banana");
        assertThat(fruits.get(0)).isEqualTo("Apple");

        Set<String> fruitSet = Set.of("Apple", "Mango", "Banana");
        assertThat(fruitSet.contains("Apple")).isEqualTo(true);
        assertThat(fruitSet.contains("strawberry")).isEqualTo(false);

        Map<String, Integer> fruitMap = Map.of("Apple", 100, "Mango", 87, "Banana", 42);
        assertThat(fruitMap.get("Apple")).isEqualTo(100);
    }
}
