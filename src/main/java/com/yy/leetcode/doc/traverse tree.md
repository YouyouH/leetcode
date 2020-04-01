##Tree

###Tree 的遍历方法 [TreeIterator](../Tree/TreeIterator.java)

    1.前序遍历(递归/stack迭代)
    2.中序遍历(递归/stack迭代迭代)
        BST(二叉搜索树的中序遍历是一个升序序列)
    3.后序遍历(递归/迭代how?)
    4.广度优先(用queue迭代)
    5.深度优先(就是前序遍历)

###Tree的构造 [ConvertSortedArraytoBST](../Tree/ConvertSortedArraytoBinarySearchTree.java)
```java
private TreeNode constructTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        //如果 start + end > Interger.max 会报错，这里采用位运算的方式避免
        int middle = (start + end) >>> 1;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = constructTree(nums,start,middle-1);
        root.right = constructTree(nums,middle+1,end);
        return root;
    }
```

###二叉搜索树（Binary Search Tree）是指一棵空树或具有如下性质的二叉树：

    1.若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值
    2.若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值
    3.任意节点的左、右子树也分别为二叉搜索树
    4.没有键值相等的节点
    5.二叉搜索树的中序遍历结果为递增序列

