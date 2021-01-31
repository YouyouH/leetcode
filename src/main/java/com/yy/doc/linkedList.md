常见技巧：


```java
1.prehead哨兵节点,用来当做重组list 的头结点。最后返回的时候return prehead.next
2.prev 指针，初始化指向哨兵节点，然后不停移动。

3.swap node in place 原地替换
    firstNode.next = secondeNode.next;
    secondNode.next = firstNode;
    此时secondeNode指向了链表头部

4.反转链表
    tmp = current.next;
    current.next = pre;
    pre = current;
    current = tmp;
    
5.从头开始遍历得到大于等于curr的前置节点，然后把curr插入到前置节点后面
        //得到大于等于curr的前置节点
        ListNode prev = dummyHead;
        while (prev.next.val <= curr.val) {
        prev = prev.next;
        }
        lastSorted.next = curr.next;
        curr.next = prev.next;
        prev.next = curr;
```



*[**merge_sort**](../../mergesort/merge_sort_top_down.png)