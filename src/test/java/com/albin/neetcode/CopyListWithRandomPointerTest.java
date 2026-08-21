package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CopyListWithRandomPointerTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new CopyListWithRandomPointer();
        RandomNode first = new RandomNode(3);
        RandomNode second = new RandomNode(7);
        RandomNode third = new RandomNode(4);
        RandomNode fourth = new RandomNode(5);
        first.next = second;
        second.next = third;
        third.next = fourth;
        second.random = fourth;
        third.random = first;
        fourth.random = second;

        RandomNode copy = solution.copyRandomList(first);
        RandomNode[] originalNodes = {first, second, third, fourth};
        RandomNode[] copiedNodes = new RandomNode[4];
        for (int i = 0; i < copiedNodes.length; i++) {
            assertNotNull(copy);
            copiedNodes[i] = copy;
            assertNotSame(originalNodes[i], copy);
            assertEquals(originalNodes[i].val, copy.val);
            copy = copy.next;
        }
        assertNull(copiedNodes[0].random);
        assertSame(copiedNodes[3], copiedNodes[1].random);
        assertSame(copiedNodes[0], copiedNodes[2].random);
        assertSame(copiedNodes[1], copiedNodes[3].random);
        assertNull(solution.copyRandomList(null));

    }
}
