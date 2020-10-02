package org.hasan.java13;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Java13Test {
    @Test
    public void testMultilineStringsPreview() {
        String textBlock = """
				Hi
				Hello
				Yes""";
        assertThat(textBlock, is("Hi\nHello\nYes"));
    }
}
