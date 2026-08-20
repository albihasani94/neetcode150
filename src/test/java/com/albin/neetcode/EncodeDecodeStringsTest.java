package com.albin.neetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EncodeDecodeStringsTest {

    private EncodeDecodeStrings solution;

    @BeforeEach
    void setUp() {
        solution = new EncodeDecodeStrings();
    }

    private void assertEncodeDecodeRoundtrip(List<String> input) {
        String encoded = solution.encode(input);
        List<String> decoded = solution.decode(encoded);
        assertEquals(input, decoded, "Decoded list must match the original input list");
    }

    @Test
    void neetcodeExample1() {
        assertEncodeDecodeRoundtrip(List.of("Hello", "World"));
    }

    @Test
    void neetcodeExample2() {
        assertEncodeDecodeRoundtrip(List.of(""));
    }

    @Test
    void emptyList() {
        assertEncodeDecodeRoundtrip(List.of());
    }

    @Test
    void multipleWords() {
        assertEncodeDecodeRoundtrip(List.of("neet", "code", "love", "you"));
    }

    @Test
    void multipleEmptyStrings() {
        assertEncodeDecodeRoundtrip(List.of("", "", ""));
    }

    @Test
    void stringsWithSpecialCharactersAndDelimiters() {
        assertEncodeDecodeRoundtrip(List.of("#", "##", "4#neet", "123#", "hello:world", ",,,,"));
    }

    @Test
    void singleWord() {
        assertEncodeDecodeRoundtrip(List.of("hello"));
    }

    @Test
    void stringsWithSpacesAndNewlines() {
        assertEncodeDecodeRoundtrip(List.of("hello world", "line1\nline2", "   "));
    }
}
