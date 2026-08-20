package com.albin.neetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupAnagramsTest {

    private GroupAnagrams solution;

    @BeforeEach
    void setUp() {
        solution = new GroupAnagrams();
    }

    @Test
    void example1_groupsAnagrams() {
        String[] strs = {"act", "pots", "tops", "cat", "stop", "hat"};
        assertGroupsEqual(
                List.of(
                        List.of("act", "cat"),
                        List.of("pots", "tops", "stop"),
                        List.of("hat")
                ),
                solution.groupAnagrams(strs)
        );
    }

    @Test
    void leetcodeExample1() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        assertGroupsEqual(
                List.of(
                        List.of("eat", "tea", "ate"),
                        List.of("tan", "nat"),
                        List.of("bat")
                ),
                solution.groupAnagrams(strs)
        );
    }

    @Test
    void example2_singleString() {
        String[] strs = {"x"};
        assertGroupsEqual(List.of(List.of("x")), solution.groupAnagrams(strs));
    }

    @Test
    void example3_emptyString() {
        String[] strs = {""};
        assertGroupsEqual(List.of(List.of("")), solution.groupAnagrams(strs));
    }

    @Test
    void singleStringHasNoAnagrams() {
        String[] strs = {"listen"};
        assertGroupsEqual(List.of(List.of("listen")), solution.groupAnagrams(strs));
    }

    @Test
    void allAnagramsGroupTogether() {
        String[] strs = {"eat", "tea", "ate"};
        assertGroupsEqual(
                List.of(List.of("eat", "tea", "ate")),
                solution.groupAnagrams(strs)
        );
    }

    @Test
    void duplicatesAreKeptWithinGroup() {
        String[] strs = {"bat", "tab", "bat"};
        assertGroupsEqual(
                List.of(List.of("bat", "tab", "bat")),
                solution.groupAnagrams(strs)
        );
    }

    private static void assertGroupsEqual(List<List<String>> expected, List<List<String>> actual) {
        assertEquals(normalize(expected), normalize(actual));
    }

    private static Map<List<String>, Long> normalize(List<List<String>> groups) {
        return groups.stream()
                .map(group -> {
                    List<String> sorted = new ArrayList<>(group);
                    Collections.sort(sorted);
                    return List.copyOf(sorted);
                })
                .collect(Collectors.groupingBy(group -> group, Collectors.counting()));
    }
}
