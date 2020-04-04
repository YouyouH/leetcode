package com.yy.leetcode.bfs;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CloneGraphTest {
    CloneGraph cloneGraph = new CloneGraph();
    @Test
    public void cloneGraph() {
        ArrayList<Node> nodes1 = new ArrayList<>();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        nodes1.add(node1);
        nodes1.add(node2);
        nodes1.add(node3);

        ArrayList<Node> node1Children = new ArrayList<>();
        node1Children.add(new Node(4));
        node1Children.add(new Node(5));
        node1Children.add(new Node(6));
        node1.neighbors = node1Children;

        Node node = new Node(99,nodes1);

        Node result = cloneGraph.cloneGraph(node);
        Assert.assertEquals(99,result.val);
    }

    @Test
    public void cloneGraph1() {
        ArrayList<Node> nodes1Children = new ArrayList<>();
        ArrayList<Node> nodes2Children = new ArrayList<>();
        ArrayList<Node> nodes3Children = new ArrayList<>();
        ArrayList<Node> nodes4Children = new ArrayList<>();

        Node node1 = new Node(1,nodes1Children);
        Node node2 = new Node(2,nodes2Children);
        Node node3 = new Node(3,nodes3Children);
        Node node4 = new Node(4,nodes4Children);

        nodes1Children.add(node2);
        nodes1Children.add(node4);

        nodes2Children.add(node1);
        nodes2Children.add(node3);

        nodes3Children.add(node2);
        nodes3Children.add(node4);

        nodes4Children.add(node1);
        nodes4Children.add(node3);

        Node result = cloneGraph.cloneGraph(node1);
        Assert.assertEquals(1,result.val);
    }
}