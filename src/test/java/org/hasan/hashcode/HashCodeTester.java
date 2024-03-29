package org.hasan.hashcode;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class HashCodeTester {
    @Test
    void testHashMapWithoutHashCode() {
        Map<ClassWithNoHashCode, String> map = new HashMap<>();
        ClassWithNoHashCode classA = new ClassWithNoHashCode("SimpleClass");
        map.put(classA, "Banana");

        // null is returned instead of 'SimpleClass' because MyClass does not implement hashCode so default hash code implementation (identity) used
        String value1 = map.get(new ClassWithNoHashCode("SimpleClass"));
        assertThat(value1).isNull();

        // Get correct value as we now use same instance as key
        String value2 = map.get(classA);
        assertThat(value2).isEqualTo("Banana");
    }

    @Test
    void testHashSetWithoutHashCode() {
        ClassWithNoHashCode class1 = new ClassWithNoHashCode("Class1");
        ClassWithNoHashCode class2 = new ClassWithNoHashCode("Class2");
        ClassWithNoHashCode duplicateClass1 = new ClassWithNoHashCode("Class1");

        Set<ClassWithNoHashCode> set = new HashSet<>();
        set.add(class1);
        set.add(class2);
        set.add(duplicateClass1);

        // Because HashCode was not implemented, duplicate object was added
        assertThat(set.size()).isEqualTo(3);
        assertThat(set.contains(new ClassWithNoHashCode("Class1"))).isFalse();
    }
}
