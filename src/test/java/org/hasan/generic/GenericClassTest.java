package org.hasan.generic;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class GenericClassTest {
    @Test
    void testAdd() {
        GenericClass<String> gc = new GenericClass<>();
        gc.add("abc");
        assertThat(gc.getList(), is(List.of("abc")));

        GenericClass<Integer> gc2 = new GenericClass<>();
        gc2.add(123);
        assertThat(gc2.getList(), is(List.of(123)));
    }
}
