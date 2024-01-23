package org.hasan.java15;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Java15Test {
    @Test
    void testTextBlocks() {
        // With text blocks, no need to escape quotes or add "+" to concatenate lines
        String json = """
        {
         "name": "painter", "qty": 18,
         "size": {"width": 1, "height": 8, "unit": "in"},
         "tags": ["writing", "pen"],
         "rating": 7
        }
        """;

        assertThat(json).isEqualTo("{\n \"name\": \"painter\", \"qty\": 18,\n \"size\": {\"width\": 1, \"height\": 8, \"unit\": \"in\"},\n \"tags\": [\"writing\", \"pen\"],\n \"rating\": 7\n}\n");
    }
}
