宽度优先搜索：

一般采用Queue来存储数据。



模板：

按照层次处理

```java
Queue<String> queue = new LinkedList<>();
queue.offer(start);
while (!queue.isEmpty()) {
    level++;
    int size = queue.size();
    while(size-- > 0) {       
        queue.poll();
        //搜索相邻节点加入queue里面
        queue.offer
    }
}
```

