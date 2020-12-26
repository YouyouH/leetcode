package com.yy.leetcode.grapth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 *
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 * https://leetcode-cn.com/problems/course-schedule/
 */
public class CourseSchedule {
    /**
     * 此题可简化为判断课程是否可以构成 有向无环图（DAG）
     *
     * 1.先得到邻接表.
     * 2.采用深度遍历的方法遍历每一个点，发现有环则返回false,如果被其他起始点遍历过则直接返回true然后继续下一个点
     *
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //邻接表
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adjacency.get(prerequisite[1]).add(prerequisite[0]);
        }
        int[] flags = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(!dfs(adjacency,flags,i)){
                return false;
            }
        }
        return true;
    }

    /**
     *
     * 1 表示当前递归访问过
     * -1 表示节点属于有向无环结构
     *
     *
     */
    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1) return false;
        if (flags[i] == -1) return true;
        flags[i] = 1;
        for (Integer integer : adjacency.get(i)) {
            if(!dfs(adjacency, flags, integer)) return false;
        }
        flags[i] = -1;
        return true;
    }

    /**
     *
     * 生成邻接表（adjacency）和入度表(indegrees)。入度表表示一个点有几条边指向它。邻接表 表示一个点指向的周围的几个点
     *
     *
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        //入度表，表示每个节点有多少个节点只指向它。index代表课程
        int[] indegrees = new int[numCourses];
        //邻接表，index表示课程
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adjacency.get(prerequisite[1]).add(prerequisite[0]);
            indegrees[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if(indegrees[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()){
            Integer course = queue.poll();
            numCourses--;
            for (Integer next : adjacency.get(course)) {
                if(--indegrees[next] == 0) queue.offer(next);
            }
        }
        return numCourses == 0;
    }
}
