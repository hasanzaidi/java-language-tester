package org.hasan.java11;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class Java11Test {
    @Test
    void testNewStringMethods() {
        assertThat(" ".isBlank()).isEqualTo(true);
        assertThat("=".repeat(2)).isEqualTo("==");
    }

    @Test
    void testNewFileMethods() throws Exception {
        Path path = Files.writeString(Files.createTempFile("test", ".txt"), "Test String");
        String str = Files.readString(path);
        assertThat(str).isEqualTo("Test String");
    }

    @Test
    void testIsEmpty() {
        Optional<String> version = Optional.empty();
        assertThat(version.isEmpty()).isEqualTo(true);
    }
}
