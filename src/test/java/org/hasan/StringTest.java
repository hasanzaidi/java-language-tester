package org.hasan;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringTest {
    @Test
    public void testAscii() {
        String a = "Hello";
        char myChar = a.charAt(2);
        assertThat(myChar, is('l'));
    }

    @Test
    public void testNonAscii() {
        String smileEmoji = "\uD83D\uDE00";
        assertThat(smileEmoji.length(), is(2));
        char smileEmojiChar = smileEmoji.charAt(0);

        // Using charAt only gets first 16 bits
        assertThat(smileEmojiChar, is('\uD83D'));

        int smileEmojiChar2 = smileEmoji.codePointAt(0);
        String smileEmojiString = new StringBuilder().appendCodePoint(smileEmojiChar2).toString();
        assertThat(smileEmojiString, is("😀"));
    }

    @Test
    public void testToBinaryString() {
        assertThat(Integer.toBinaryString(2), is("10"));
        assertThat(Integer.toBinaryString(-2), is("11111111111111111111111111111110"));
    }

    @Test
    public void testStringPool() {
        String a = new String("abc");
        String b = "abc";
        String c = "abc";

        // Because of String pool can use either .equals or == for Strings when creating Strings using quotes
        assertThat(b.equals(c), is(true));
        assertThat(b == c, is(true));

        // Because need .equals when creating Strings with new
        assertThat(a.equals(b), is(true));
        assertThat(a == b, is(false));
    }
}
