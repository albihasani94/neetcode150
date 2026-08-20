package com.albin.neetcode;

import java.util.*;

/**
 * <a href="https://neetcode.io/problems/anagram-groups/question?list=neetcode150">NeetCode: Group Anagrams</a>
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String str : strs) {
            var characters = str.toCharArray();
            Arrays.sort(characters);
            String key = String.valueOf(characters);

            anagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return anagrams.values().stream().toList();
    }
}
