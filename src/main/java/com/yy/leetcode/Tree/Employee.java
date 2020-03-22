package com.yy.leetcode.Tree;

import java.util.List;

/**
 * @author youyouhuang
 * @create 2020-03-22
 * @desc
 **/

// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
