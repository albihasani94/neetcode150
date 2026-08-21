package com.albin.neetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

final class TestSupport {

    private TestSupport() {
    }

    static ListNode list(int... values) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        for (int value : values) {
            tail.next = new ListNode(value);
            tail = tail.next;
        }
        return dummy.next;
    }

    static int[] listValues(ListNode head) {
        List<Integer> values = new ArrayList<>();
        Set<ListNode> seen = new HashSet<>();
        while (head != null && seen.add(head)) {
            values.add(head.val);
            head = head.next;
        }
        return values.stream().mapToInt(Integer::intValue).toArray();
    }

    static TreeNode tree(Integer... values) {
        if (values.length == 0 || values[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty() && index < values.length) {
            TreeNode node = queue.remove();
            if (index < values.length && values[index] != null) {
                node.left = new TreeNode(values[index]);
                queue.add(node.left);
            }
            index++;
            if (index < values.length && values[index] != null) {
                node.right = new TreeNode(values[index]);
                queue.add(node.right);
            }
            index++;
        }
        return root;
    }

    static TreeNode find(TreeNode root, int value) {
        if (root == null || root.val == value) {
            return root;
        }
        TreeNode left = find(root.left, value);
        return left != null ? left : find(root.right, value);
    }

    static List<Integer> treeValues(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        List<Integer> values = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode node : level) {
                if (node == null) {
                    values.add(null);
                } else {
                    values.add(node.val);
                    next.add(node.left);
                    next.add(node.right);
                }
            }
            level = next;
        }
        int last = values.size() - 1;
        while (last >= 0 && values.get(last) == null) {
            last--;
        }
        return values.subList(0, last + 1);
    }

    static void assertNestedIntsIgnoringOrder(int[][] expected, List<List<Integer>> actual) {
        assertNotNull(actual);
        List<String> expectedValues = Arrays.stream(expected)
            .map(row -> Arrays.stream(row).sorted().mapToObj(String::valueOf).collect(Collectors.joining(",")))
            .sorted()
            .toList();
        List<String> actualValues = actual.stream()
            .map(row -> row.stream().sorted().map(String::valueOf).collect(Collectors.joining(",")))
            .sorted()
            .toList();
        assertEquals(expectedValues, actualValues);
    }

    static void assertNestedIntRowsIgnoringOrder(int[][] expected, List<List<Integer>> actual) {
        assertNotNull(actual);
        List<String> expectedValues = Arrays.stream(expected).map(Arrays::toString).sorted().toList();
        List<String> actualValues = actual.stream()
            .map(row -> row.toString())
            .sorted()
            .toList();
        assertEquals(expectedValues, actualValues);
    }

    static void assertNestedStringsIgnoringOrder(String[][] expected, List<List<String>> actual) {
        assertNotNull(actual);
        List<String> expectedValues = Arrays.stream(expected)
            .map(row -> String.join("\u0000", row))
            .sorted()
            .toList();
        List<String> actualValues = actual.stream()
            .map(row -> String.join("\u0000", row))
            .sorted()
            .toList();
        assertEquals(expectedValues, actualValues);
    }

    static void assertStringsIgnoringOrder(List<String> expected, List<String> actual) {
        assertNotNull(actual);
        assertEquals(expected.stream().sorted().toList(), actual.stream().sorted().toList());
    }

    static void assertRowsIgnoringOrder(int[][] expected, int[][] actual) {
        assertNotNull(actual);
        List<String> expectedRows = Arrays.stream(expected).map(Arrays::toString).sorted().toList();
        List<String> actualRows = Arrays.stream(actual).map(Arrays::toString).sorted().toList();
        assertEquals(expectedRows, actualRows);
    }

    static void assertMatrixEquals(int[][] expected, int[][] actual) {
        assertNotNull(actual);
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], "row " + i);
        }
    }

    static void assertMatrixEquals(char[][] expected, char[][] actual) {
        assertNotNull(actual);
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], "row " + i);
        }
    }

    static GraphNode graph(int[][] adjacency) {
        if (adjacency.length == 0) {
            return null;
        }
        GraphNode[] nodes = new GraphNode[adjacency.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new GraphNode(i + 1);
        }
        for (int i = 0; i < adjacency.length; i++) {
            for (int neighbor : adjacency[i]) {
                nodes[i].neighbors.add(nodes[neighbor - 1]);
            }
        }
        return nodes[0];
    }

    static void assertGraphClone(GraphNode original, GraphNode clone, int[][] adjacency) {
        if (original == null) {
            assertEquals(null, clone);
            return;
        }
        assertNotNull(clone);
        Map<Integer, GraphNode> originalByValue = graphNodes(original);
        Map<Integer, GraphNode> cloneByValue = graphNodes(clone);
        assertEquals(originalByValue.keySet(), cloneByValue.keySet());
        for (int i = 1; i <= adjacency.length; i++) {
            assertNotSame(originalByValue.get(i), cloneByValue.get(i));
            int[] actual = cloneByValue.get(i).neighbors.stream().mapToInt(node -> node.val).sorted().toArray();
            int[] expected = Arrays.stream(adjacency[i - 1]).sorted().toArray();
            assertArrayEquals(expected, actual);
        }
    }

    private static Map<Integer, GraphNode> graphNodes(GraphNode root) {
        Map<Integer, GraphNode> nodes = new HashMap<>();
        Queue<GraphNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            GraphNode node = queue.remove();
            if (nodes.putIfAbsent(node.val, node) == null) {
                queue.addAll(node.neighbors);
            }
        }
        return nodes;
    }

    static void assertTopologicalOrder(int courses, int[][] prerequisites, int[] order) {
        assertNotNull(order);
        assertEquals(courses, order.length);
        int[] position = new int[courses];
        boolean[] seen = new boolean[courses];
        for (int i = 0; i < order.length; i++) {
            assertTrue(order[i] >= 0 && order[i] < courses);
            assertTrue(!seen[order[i]], "course appears more than once");
            seen[order[i]] = true;
            position[order[i]] = i;
        }
        for (int[] prerequisite : prerequisites) {
            assertTrue(position[prerequisite[1]] < position[prerequisite[0]]);
        }
    }
}
