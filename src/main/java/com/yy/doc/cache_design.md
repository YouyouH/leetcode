###### LRU Cache LRU (最近最少使用) 缓存机制 。
```java
private Node dummyHead = new Node(0,0);
private Node dummyTail= new Node(0,0);
private int capacity = 0;
private int size = 0;
private Map<Integer, Node> map = new HashMap<>();
```




###### LFU Cache 最不经常使用（LFU）缓存算法设计并实现数据结构。
```java
int minfreq, capacity;
    Map<Integer, Node> key_table;
    //key是使用频率，链表是用来按照时间顺序排序
    Map<Integer, LinkedList<Node>> freq_table;
```