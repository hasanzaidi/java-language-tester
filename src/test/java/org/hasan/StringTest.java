package org.hasan;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

class StringTest {
    @Test
    void testAscii() {
        String a = "Hello";
        char myChar = a.charAt(2);
        assertThat(myChar, is('l'));
    }

    @Test
    void testNonAscii() {
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
    void testToBinaryString() {
        assertThat(Integer.toBinaryString(2), is("10"));
        assertThat(Integer.toBinaryString(-2), is("11111111111111111111111111111110"));
    }

    @Test
    void testStringPool() {
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

    @Test
    void testRetrievingAsciiAndUnicode() {
        List<Integer> list1 = new ArrayList<>();
        String str = "a" + "😀" + "a";
        for (int i = 0; i < str.length(); i++) {
            int v = str.codePointAt(i);
            list1.add(v);
        }

        assertThat(list1, hasSize(4));
        assertThat(list1.get(0), is(97));
        assertThat(list1.get(1), is(128512));

        // Value 56832 is half of emoji, which is not correct
        assertThat(list1.get(2), is(56832));
        assertThat(list1.get(3), is(97));

        // Better way by getting charCount
        List<Integer> list2 = new ArrayList<>();
        int offset = 0;
        while (offset < str.length()) {
            int v = str.codePointAt(offset);
            list2.add(v);

            offset += Character.charCount(v);
        }

        // Now the list has only 3 values, as expected
        assertThat(list2, hasSize(3));
        assertThat(list2.get(0), is(97));
        assertThat(list2.get(1), is(128512));
        assertThat(list2.get(2), is(97));
    }
}
