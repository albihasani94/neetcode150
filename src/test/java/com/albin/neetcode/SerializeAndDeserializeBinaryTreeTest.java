package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerializeAndDeserializeBinaryTreeTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var codec = new Codec();
        TreeNode root = TestSupport.tree(1, 2, 3, null, null, 4, 5);
        assertEquals(TestSupport.treeValues(root), TestSupport.treeValues(codec.deserialize(codec.serialize(root))));
        assertNull(codec.deserialize(codec.serialize(null)));

    }
}
