#1
select t.name
from teacher t
where t.dept is null;

#5
## COALESCE,返回第一个非空表达式
select t.name, COALESCE(t.mobile, '07986 444 2266')
from teacher t

#6
select t.name, COALESCE(d.name, 'None')
from teacher t
         left join dept d
                   on t.dept = d.id

#7
select count(t.name), count(t.mobile)
from teacher t

#8
select d.name, count(t.name)
from teacher t
         right join dept d on d.id = t.dept
group by d.name

#9
## case when / IF
select t.name, case when t.dept in (1, 2) then 'Sci' ELSE 'Art' end
from teacher t;

select t.name, IF(t.dept in (1, 2), 'Sci', 'Art')
from teacher t;

#10
SELECT name, CASE WHEN dept IN (1, 2) THEN 'Sci' WHEN dept = 3 THEN 'Art' ELSE 'None' END from teacher;
