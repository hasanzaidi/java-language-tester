package org.hasan.reflection;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import static org.assertj.core.api.Assertions.assertThat;

class ReflectionTest {
    @Test
    void testUpdatingValueInField() throws Exception {
        // Value initially
        SimpleClass object = new SimpleClass();
        assertThat(object.getMyPrivateField()).isEqualTo(123);

        Class<?> c = object.getClass();
        Field id = c.getDeclaredField("myPrivateField");
        id.setAccessible(true);
        id.set(object, 456);
        assertThat(object.getMyPrivateField()).isEqualTo(456);
    }
}
