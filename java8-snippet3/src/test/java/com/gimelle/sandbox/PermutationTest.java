package com.gimelle.sandbox;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PermutationTest {

    @Test
    public void calculatePermutationOfAString() {

        String originalString = "123";
        List<String> expectedPermutations = Arrays.asList("123", "132", "213", "231", "312", "321");

        List<String> res = new ArrayList<>();
        permutations("", originalString, res);

        assertThat(res, equalTo(expectedPermutations));
    }

    private void permutations(String perm, String word, List<String> acc) {
        System.out.println(perm + " - " + word);

        if (word.isEmpty()) {
            acc.add(perm + word);
        } else {
            for (int i = 0; i < word.length(); i++) {
                permutations(perm + word.charAt(i),
                        word.substring(0,i)  + word.substring(i + 1, word.length()), acc);
            }
        }
    }
}
