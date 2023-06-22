package org.hasan.java10;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class Java10Test {
    @Test
    void testVarKeyword() {
        var myString = "hello world";
        assertThat(myString, is("hello world"));
    }
}
