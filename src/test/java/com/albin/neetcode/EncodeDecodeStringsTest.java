package com.albin.neetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class EncodeDecodeStringsTest {

    @Test
    public void encodeDecodeRoundtrip() {
        EncodeDecodeStrings codec = new EncodeDecodeStrings();
        List<String> input = Arrays.asList("Hello","World","",":;#|/\\", "last");
        String encoded = codec.encode(input);
        List<String> decoded = codec.decode(encoded);
        assertEquals(input, decoded);
    }
}
