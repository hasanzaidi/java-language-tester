package org.hasan;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegExpTest {
    @Test
    public void findTextInString() {
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
        assertThat(consumerKey, is("123"));
    }

    @Test
    public void checkIfTextStartsWithNum() {
        String letterInput = "abc myvalue";
        String numberInput = "123 myvalue";

        assertThat(letterInput.matches("\\d.*"), is(false));
        assertThat(numberInput.matches("\\d.*"), is(true));
    }
}
