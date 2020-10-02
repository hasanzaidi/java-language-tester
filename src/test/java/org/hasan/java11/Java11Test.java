package org.hasan.java11;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Java11Test {
    @Test
    public void testNewStringMethods() {
        assertThat(" ".isBlank(), is(true));
        assertThat("=".repeat(2), is("=="));
    }

    @Test
    public void testNewFileMethods() throws IOException {
        Path path = Files.writeString(Files.createTempFile("test", ".txt"), "Test String");
        String str = Files.readString(path);
        assertThat(str, is("Test String"));
    }
}
