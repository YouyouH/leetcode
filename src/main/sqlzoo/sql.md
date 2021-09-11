1.group by 依赖的column需要出现在select或者functionally dependent？
    SQL92 requires that all columns (except aggregates) in the select clause is part of the group by clause. SQL99 loosens this restriction a bit and states that all columns in the select clause must be functionally dependent of the group by clause. MySQL by default allows for partial group by and this may produce non-deterministic answers

The GROUP BY clause is used often used in conjunction with an aggregate function such as SUM() and AVG(). The GROUP BY clause reduces the number of rows returned by rolling them up and calculating the sums or averages for each group.

2.RANK() OVER (ORDER BY f DESC)
按照f排序

3.PARTION BY
window_function ( expression ) OVER (
PARTITION BY expression1, expression2, ...
order_clause
frame_clause
)
按照 expression1, expression2 group，但是不会减少返回的
The PARTITION BY clause divides the result set into partitions and changes how the window function is calculated. The PARTITION BY clause does not reduce the number of rows returned.
partion by 适合做分析，例如对每条记录排序（rank）

