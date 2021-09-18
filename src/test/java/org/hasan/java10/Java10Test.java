package org.hasan.java10;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Java10Test {
    @Test
    public void testVarKeyword() {
        var myString = "hello world";
        assertThat(myString, is("hello world"));
    }
}
