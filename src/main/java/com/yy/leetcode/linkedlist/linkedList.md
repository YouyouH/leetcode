常见技巧：


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
    


*[**merge_sort**](../../mergesort/merge_sort_top_down.png)