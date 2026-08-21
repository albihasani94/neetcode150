package com.albin.neetcode;

import java.util.ArrayList;
import java.util.List;

/** Node type supplied by Clone Graph. */
public class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode() {
        this(0);
    }

    public GraphNode(int val) {
        this(val, new ArrayList<>());
    }

    public GraphNode(int val, List<GraphNode> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
