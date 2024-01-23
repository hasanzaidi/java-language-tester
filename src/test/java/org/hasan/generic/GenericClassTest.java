package org.hasan.generic;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GenericClassTest {
    @Test
    void testAdd() {
        GenericClass<String> gc = new GenericClass<>();
        gc.add("abc");
        assertThat(gc.getList()).isEqualTo(List.of("abc"));

        GenericClass<Integer> gc2 = new GenericClass<>();
        gc2.add(123);
        assertThat(gc2.getList()).isEqualTo(List.of(123));
    }
}
