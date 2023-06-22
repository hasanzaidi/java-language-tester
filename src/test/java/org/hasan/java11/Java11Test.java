package org.hasan.java11;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class Java11Test {
    @Test
    void testNewStringMethods() {
        assertThat(" ".isBlank(), is(true));
        assertThat("=".repeat(2), is("=="));
    }

    @Test
    void testNewFileMethods() throws Exception {
        Path path = Files.writeString(Files.createTempFile("test", ".txt"), "Test String");
        String str = Files.readString(path);
        assertThat(str, is("Test String"));
    }
}
