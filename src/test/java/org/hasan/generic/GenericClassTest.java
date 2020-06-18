package org.hasan.generic;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GenericClassTest {
    @Test
    public void testAdd() {
        GenericClass<String> gc = new GenericClass<>();
        gc.add("abc");
        assertThat(gc.getList(), is(List.of("abc")));

        GenericClass<Integer> gc2 = new GenericClass<>();
        gc2.add(123);
        assertThat(gc2.getList(), is(List.of(123)));
    }
}
