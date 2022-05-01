package org.hasan.java15;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Java15Test {
    @Test
    public void testTextBlocks() {
        // With text blocks, no need to escape quotes or add "+" to concatenate lines
        String json = """
        {
         "name": "painter", "qty": 18,
         "size": {"width": 1, "height": 8, "unit": "in"},
         "tags": ["writing", "pen"],
         "rating": 7
        }
        """;

        assertThat(json, is("{\n \"name\": \"painter\", \"qty\": 18,\n \"size\": {\"width\": 1, \"height\": 8, \"unit\": \"in\"},\n \"tags\": [\"writing\", \"pen\"],\n \"rating\": 7\n}\n"));
    }
}
