package com.yy.leetcode.design;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 *
 * 实现 LRUCache 类：
 *
 *     LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 *     int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 *     void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *
 *
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LRUCache {

    private Node dummyHead = new Node(0,0);
    private Node dummyTail= new Node(0,0);
    private int capacity = 0;
    private int size = 0;
    private Map<Integer, Node> map = new HashMap<>();

    private class Node {
        private int key;
        private int value;
        private Node pre;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 双向链表存储数据，hashmap用来定位链表节点
     *
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        moveToHead(map.get(key));
        return map.get(key).value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = this.map.get(key);
            node.value = value;
            moveToHead(node);
        }else{
            size++;
            Node node = new Node(key, value);
            this.map.put(key, node);
            if(size > capacity){
                removeTail();
                size--;
            }
            insertAtHead(node);

        }

    }

    private void insertAtHead(Node node) {
        Node next = dummyHead.next;
        next.pre = node;
        node.next = next;
        node.pre = dummyHead;
        dummyHead.next = node;
    }

    private void removeTail() {
        map.remove(dummyTail.pre.key);
        Node pre = dummyTail.pre;
        Node prepre = pre.pre;
        prepre.next = dummyTail;
        dummyTail.pre = prepre;
    }

    private void moveToHead(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        insertAtHead(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
