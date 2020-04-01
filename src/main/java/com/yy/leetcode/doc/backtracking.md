### Back Tracking 回溯
```
1.回溯算法的本质就是多叉树的遍历，一般需要穷尽所有情况，复杂度n!。
2.对比BST，相当于在前序遍历做选择，然后在后序遍历撤销选择。
```

####框架：

    for 选择 in 选择列表:
    
    ​    \# 做选择
    
    ​    将该选择从选择列表移除
    
    ​    路径.add(选择)
    
    ​    backtrack(路径, 选择列表)
    
    ​    \# 撤销选择
    
    ​    路径.remove(选择)
    
    ​    将该选择再加入选择列表
    
###题目类型：
    1.全排列，先排序。AB，BA都算。这种类型每次递归都要从头开始循环，并且用辅助数组booolen[] 来去掉已经用过的字符。
   [活字印刷](../backtracking/LetterCasePermutation.java)
   
    2.最大子集，先排序。AB，BA是重复的。这种类型每次递归时index+1，不要从头开始。
   [最大子集](../backtracking/SubsetsII.java)