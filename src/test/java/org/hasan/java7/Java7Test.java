package org.hasan.java7;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Java7Test {
    @Test
    void stringInSwitchStatements() {
        // Given:
        String status = "EXECUTE";

        // When:
        String result = "";
        switch (status) {
            case "NEW":
                result = "Status is New";
                break;

            case "EXECUTE":
                result = "Status is Execute";
                break;

            case "PENDING":
                result = "Status is Pending";
                break;
        }

        // Then:
        assertThat(result).isEqualTo("Status is Execute");
    }

    @Test
    void multipleExceptionCatching() {
        try {
            int million = 1_000_000;
            assertThat(million).isEqualTo(1000000);
        } catch (IllegalArgumentException | NullPointerException e) {
            assertTrue(true);
        }
    }

    @Test
    void tryWithResources() {
        // Given:
        List<String> content = new ArrayList<>();

        // When:
        try (BufferedReader br = new BufferedReader(new FileReader("pom.xml"))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Then:
        assertThat(content.get(2).trim()).isEqualTo("<modelVersion>4.0.0</modelVersion>");
    }
}
