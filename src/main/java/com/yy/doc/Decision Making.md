The general problem statement for this pattern is forgiven situation decide whether to use or not to use the current state. So, the problem requires you to make a decision at a current state.

Statement

    Given a set of values find an answer with an option to choose or ignore the current value.
    给出一组数字，决定选择或者放弃当前数字

Approach

    If you decide to choose the current value use the previous result where the value was ignored; vice-versa, if you decide to ignore the current value use previous result where value was used.
    如果你决定选择当前数字，则使用上一次的并且数字被忽略的结果。
    反之，如果你决定忽略当前的数字，则使用上次的并且值被选择的结果。
    
    dp[i][j]: i表示当前值，j表示是否做选择。 
    比如1表示选择，0表示不选择。
    则
    dp[i][1] = dp[i-1][0] + a[i];
    dp[1][0] = dp[i-1][1]
    