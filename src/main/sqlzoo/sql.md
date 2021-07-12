1.group by 依赖的column需要出现在select或者functionally dependent？
    SQL92 requires that all columns (except aggregates) in the select clause is part of the group by clause. SQL99 loosens this restriction a bit and states that all columns in the select clause must be functionally dependent of the group by clause. MySQL by default allows for partial group by and this may produce non-deterministic answers
