package com.albin.neetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GroupAnagramsTest {

    private GroupAnagrams solution;

    @BeforeEach
    void setUp() {
        solution = new GroupAnagrams();
    }

    @Test
    void example1_groupsAnagrams() {
        String[] strs = {"act", "pots", "tops", "cat", "stop", "hat"};
        List<List<String>> groups = solution.groupAnagrams(strs);
        Set<Set<String>> normalized = normalize(groups);

        assertEquals(3, normalized.size(), "There should be three anagram groups");
        assertTrue(normalized.contains(group("act", "cat")));
        assertTrue(normalized.contains(group("pots", "tops", "stop")));
        assertTrue(normalized.contains(group("hat")));
    }

    @Test
    void leetcodeExample1() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groups = solution.groupAnagrams(strs);
        Set<Set<String>> normalized = normalize(groups);

        assertEquals(3, normalized.size());
        assertTrue(normalized.contains(group("eat", "tea", "ate")));
        assertTrue(normalized.contains(group("tan", "nat")));
        assertTrue(normalized.contains(group("bat")));
    }

    @Test
    void example2_singleString() {
        String[] strs = {"x"};
        List<List<String>> groups = solution.groupAnagrams(strs);
        Set<Set<String>> normalized = normalize(groups);

        assertEquals(1, normalized.size(), "There should be one anagram group");
        assertTrue(normalized.contains(group("x")));
    }

    @Test
    void example3_emptyString() {
        String[] strs = {""};
        List<List<String>> groups = solution.groupAnagrams(strs);
        Set<Set<String>> normalized = normalize(groups);

        assertEquals(1, normalized.size(), "There should be one anagram group");
        assertTrue(normalized.contains(group("")));
    }

    @Test
    void singleStringHasNoAnagrams() {
        String[] strs = {"listen"};
        List<List<String>> groups = solution.groupAnagrams(strs);
        Set<Set<String>> normalized = normalize(groups);

        assertEquals(1, normalized.size());
        assertTrue(normalized.contains(group("listen")));
    }

    @Test
    void allAnagramsGroupTogether() {
        String[] strs = {"eat", "tea", "ate"};
        List<List<String>> groups = solution.groupAnagrams(strs);
        Set<Set<String>> normalized = normalize(groups);

        assertEquals(1, normalized.size(), "All three strings are anagrams of each other");
        assertTrue(normalized.contains(group("eat", "tea", "ate")));
    }

    @Test
    void duplicatesAreKeptWithinGroup() {
        String[] strs = {"bat", "tab", "bat"};
        List<List<String>> groups = solution.groupAnagrams(strs);
        Set<Set<String>> normalized = normalize(groups);

        assertEquals(1, normalized.size());
        assertTrue(normalized.contains(group("bat", "tab")));
        assertEquals(3, groups.getFirst().size());
    }

    private static Set<Set<String>> normalize(List<List<String>> groups) {
        Set<Set<String>> normalized = new HashSet<>();
        for (List<String> group : groups) {
            normalized.add(new HashSet<>(group));
        }
        return normalized;
    }

    private static Set<String> group(String... words) {
        return new HashSet<>(List.of(words));
    }
}
