package org.hasan.generic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GenericClassTest {
    @Test
    void testAdd() {
        GenericClass<String> gc = new GenericClass<>();
        gc.add("abc");
        assertThat(gc.getList()).containsExactly("abc");

        GenericClass<Integer> gc2 = new GenericClass<>();
        gc2.add(123);
        assertThat(gc2.getList()).containsExactly(123);
    }
}
