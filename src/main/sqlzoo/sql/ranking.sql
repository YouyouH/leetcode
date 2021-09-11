#窗口函数
#dense_rank() over (partition by 'column' order by 'column') from table;
#为什么叫窗口函数? partion会把表分成窗口
select Score, dense_rank() over (order by Score Desc) as 'Rank'
from Scores;

select Department, Employee, Salary
from (select d.Name as    Department,
             e.Name as    Employee,
             Salary,
             dense_rank() over (partition by e.DepartmentId order by e.Salary Desc)
    as ranking
      from Employee e
               inner join Department d on e.DepartmentId = d.id) as sort
where ranking = 1;

#having 跟 group by 之类的聚合函数一起使用,where不能用在聚合函数上
select Email
from Person
group by Email
having count(Email) > 1;

#in 的元组用法
select d.Name as Department, e.Name as Employee, Salary
from Employee e
         inner join Department d
                    on e.DepartmentId = d.Id
where (DepartmentId, Salary) in
      (
          select DepartmentId, max(Salary)
          from Employee
          group by DepartmentId
      );
# DATEDIFF 函数用来比较date类型数据
select a.id from Weather a inner join Weather b on DATEDIFF(a.recordDate, b.recordDate) = 1
where a.Temperature > b.Temperature order by a.recordDate ASC;

#异或xor
select name,population,area from world where population > 250000000 xor area > 3000000

#all或者any 表示大于subquery里面的每一个，any表示大于任意一个即可
SELECT name FROM world
WHERE population > ALL
      (SELECT population FROM world
       WHERE continent='Europe')