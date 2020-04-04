package com.yy.leetcode.bfs;
/**
 * @author youyouhuang
 * @create 2020-04-04
 **/

import java.util.*;
import java.util.stream.Collectors;

/**
 *https://leetcode-cn.com/problems/clone-graph/
 *<p>
 *给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 *</p>
 **/
public class CloneGraph {

    /**
     * 注意已经clone过的就不能再clone了
     */
    public Node cloneGraph(Node node) {
        if(null == node){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> resultQueue = new LinkedList<>();
        Map<Integer,Node> visited = new HashMap<>();
        queue.offer(node);
        Node rootClone = new Node(node.val);
        visited.put(node.val,rootClone);
        resultQueue.offer(rootClone);

        while(!queue.isEmpty()){
            Node n = queue.poll();
            Node cloneNode = resultQueue.poll();
            ArrayList<Node> tmp = new ArrayList<>();
            for (Node neighbor : n.neighbors) {
                Node newNode = new Node(neighbor.val);
                if(!visited.containsKey(newNode.val)) {
                    tmp.add(newNode);
                    visited.put(newNode.val,newNode);
                    queue.offer(neighbor);
                    resultQueue.offer(newNode);
                }else{
                    tmp.add(visited.get(newNode.val));
                }

            }
            cloneNode.neighbors = tmp;
        }
        return rootClone;

    }

}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
    @Override
    public String toString(){
        return String.valueOf(val);
    }
}
