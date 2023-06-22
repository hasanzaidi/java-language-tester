package org.hasan.files;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class FilesTest {
    @Test
    void testReadingFile() throws Exception {
        // Given/When:
        String content = readFromFile(this.getClass(), "/org/hasan/files/myfile.txt");

        // Then:
        assertThat(content, is("hello"));
    }

    private String readFromFile(Class testClass, String filename) throws IOException {
        try (BufferedReader r = new BufferedReader(new InputStreamReader(testClass.getResourceAsStream(filename)))) {
            return r.lines().collect(Collectors.joining());
        }
    }
}
