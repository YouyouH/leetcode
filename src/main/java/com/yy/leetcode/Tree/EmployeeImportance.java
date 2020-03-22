package com.yy.leetcode.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author youyouhuang
 * @create 2020-03-22
 * @desc https://leetcode-cn.com/problems/employee-importance/
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
 * <p>
 * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
 * <p>
 * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
 * <p>
 * <p>
 * 一个员工最多有一个直系领导，但是可以有多个直系下属
 * 员工数量不超过2000。
 **/

/**
 * 方法一:宽度优先算法
 * 方法二:深度优先算法
 */
public class EmployeeImportance {

    //宽度优先算法
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null) {
            return 0;
        }
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        LinkedList<Integer> idQueue = new LinkedList<>();
        LinkedList<Integer> ids = new LinkedList<>();

        Employee employee = map.get(id);
        if (null == employee) {
            return 0;
        }
        ids.add(employee.id);

        idQueue.addAll(employee.subordinates);
        ids.addAll(employee.subordinates);
        while (!idQueue.isEmpty()) {
            Integer idNumber = idQueue.pop();
            List<Integer> subordinates = map.get(idNumber).subordinates;
            if (null != subordinates) {
                idQueue.addAll(subordinates);
                ids.addAll(subordinates);
            }
        }
        return ids.stream().mapToInt(id0 -> map.get(id0).importance).sum();
    }

    //深度优先
    public int getImportance1(List<Employee> employees, int id) {
        if (employees == null) {
            return 0;
        }
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Employee employee = map.get(id);

        return dfs(employee, map);
    }

    private int dfs(Employee employee, HashMap<Integer, Employee> map) {
        int importance = employee.importance;
        List<Integer> ids = employee.subordinates;
        if (ids == null) {
            return importance;
        }
        for (Integer id : ids) {
            importance += dfs(map.get(id), map);
        }
        return importance;
    }
}
