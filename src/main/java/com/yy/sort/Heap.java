package com.yy.sort;

/**
 * https://www.cnblogs.com/sidewinder/p/13733329.html
 *
 * https://blog.csdn.net/itcats_cn/article/details/83385402
 * 其中针对于k节点，其父节点是 (k-1)/2 (注意： 0节点除外)
 * 对于k节点，其两个儿子节点分布是: left = 2*k + 1 ; right = 2 *k + 2;
 *
 * 大根堆两个主要算法：
 *
 *     向上调整算法： 主要用于插入新元数的时候；即把新添加的数从最后开始不断往上升
 *     向下调整算法： 用于从数组创建一个大根堆，或者删除元素的时候；从最后一个非叶子结点开始往前遍历，把较小的元素往下移
 *
 * 最后一个节点是heapSize -1， 所以最后一个节点的父节点就是最后一个非叶子节点：（完全二叉树规律）；
 * 最后一个非叶子节点是（heapSize - 2）/2;
 */
public class Heap {

    int[] arr = new int[10];

    int heapSize = 0;


    public void push(int value) {
        arr[heapSize++] = value;
        //一个新元素push进去，就先放到最后面，然后不停上浮
        adjustUp((heapSize - 2) / 2);
    }


    public void poll() {
        swap(0, heapSize - 1);
        heapSize--;
        adjustDown(0);
    }

    // 构建一个最大堆的过程：就是从后往前
    // 针对每个非叶子节点，做向下调整算
    // 参数是：将传入数组，构建大根堆。
    public void buildMaxHeap(int[] _arr) {
        arr = _arr;
        heapSize = _arr.length;
        // 找到非叶子节点，然后向下调整;
//        最后一个非叶子节点是（heapSize - 2）/2;
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            adjustDown(i);
        }
    }

    // 向下调整算法
    public void adjustDown(int k) {
        // 非叶子节点，不用向下调整。
        // 判断叶子节点：(堆大小是1 或 就一般的最后一个节点的父节点之后的节点都是叶子)
        if (heapSize == 1 || k > (heapSize - 2) / 2)
            return;
        int left = 2 * k + 1, right = 2 * k + 2, largest = left;
        if (right < heapSize && arr[right] > arr[left]) {
            largest = right;
        }

        if (arr[largest] > arr[k]) {
            swap(largest, k);
            adjustDown(largest);
        }

    }

    // 向上调整算法
    public void adjustUp(int k) {
        if (k < 0)
            return;
        int left = 2 * k + 1, right = 2 * k + 2, largest = left;
        if (right < heapSize && arr[right] > arr[left]) {
            largest = right;
        }

        if (arr[largest] > arr[k]) {
            swap(largest, k);
            //其中针对于k节点，其父节点是 (k-1)/2 (注意： 0节点除外)
            adjustUp((k - 1) / 2);
        }
    }

    void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 排序只需要一直删除，堆顶元素， 放到堆末尾;
    // 大根堆，就能进行从小到大排序。
    void sort() {
        for (int i = 0; i < arr.length; i++) {
            poll();
        }
    }
}
