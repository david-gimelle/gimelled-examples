package com.gimelle.sandbox.javaeight;

import org.junit.Test;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringJoinerTest {

    @Test
    public void StringJoinerAreCool() {

        assertThat(
                new StringJoiner(";")
                        .add("1")
                        .add("2")
                        .add("3")
                        .toString(),
                equalTo(
                        "1;2;3")
        );

    }

    @Test
    public void joinACoupleOfString() {
        assertThat(
                String.join(" ", "toto", "is", "a", "hero!"),
                equalTo("toto is a hero!")
        );

        String[] arrays = {"A", "B", "C"};

        assertThat(
                String.join("#", arrays),
                equalTo("A#B#C")
        );

        //Works also with a List!
        assertThat(
                String.join("->", Arrays.asList(arrays)),
                equalTo("A->B->C")
        );
    }

    @Test
    public void canUseAlsoJoinInCollector() {

        Stream<String> stuff = Stream.of("Janvier", "February", "Mars");

        assertThat(
                stuff.collect(Collectors.joining("; ")),
                equalTo("Janvier; February; Mars")
        );

    }
}
