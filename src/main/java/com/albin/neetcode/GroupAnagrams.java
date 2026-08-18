package com.albin.neetcode;

import java.util.*;

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
