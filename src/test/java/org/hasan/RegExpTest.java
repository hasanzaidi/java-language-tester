package org.hasan;

import org.junit.jupiter.api.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.assertj.core.api.Assertions.assertThat;

class RegExpTest {
    @Test
    void findTextInString() {
        // Given:
        String input = "OAuth realm=\"http://myapi.com/\", oauth_consumer_key=\"123\", oauth_token=\"abcd\"";

        // When:
        Pattern p = Pattern.compile(".+oauth_consumer_key=\"(\\w+)\".+");
        Matcher m = p.matcher(input);
        String consumerKey = "";
        if (m.matches()) {
            consumerKey = m.group(1);
        }

        // Then:
        assertThat(consumerKey).isEqualTo("123");
    }

    @Test
    void checkIfTextStartsWithNum() {
        String letterInput = "abc myvalue";
        String numberInput = "123 myvalue";

        assertThat(letterInput.matches("\\d.*")).isFalse();
        assertThat(numberInput.matches("\\d.*")).isTrue();
    }
}
