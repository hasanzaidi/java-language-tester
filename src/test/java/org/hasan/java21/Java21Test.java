package org.hasan.java21;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.SequencedCollection;
import java.util.SequencedSet;

import static org.assertj.core.api.Assertions.assertThat;

class Java21Test {
    @Test
    void testSequencedCollections() {
        SequencedCollection<Integer> list = List.of(1, 2, 3);
        assertThat(list.getFirst()).isEqualTo(1);

        SequencedSet<Integer> set = new LinkedHashSet<>();
        set.add(1);
        assertThat(set.getFirst()).isEqualTo(1);
    }
}
