package org.hasan.reflection;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReflectionTest {
    @Test
    public void testUpdatingValueInField() throws Exception {
        // Value initially
        SimpleClass object = new SimpleClass();
        assertThat(object.getMyPrivateField(), is(123));

        Class<?> c = object.getClass();
        Field id = c.getDeclaredField("myPrivateField");
        id.setAccessible(true);
        id.set(object, 456);
        assertThat(object.getMyPrivateField(), is(456));
    }
}
