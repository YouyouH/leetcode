<p>现有一个记作二维矩阵 <code>frame</code> 的珠宝架，其中 <code>frame[i][j]</code> 为该位置珠宝的价值。拿取珠宝的规则为：</p>

<ul> 
 <li>只能从架子的左上角开始拿珠宝</li> 
 <li>每次可以移动到右侧或下侧的相邻位置</li> 
 <li>到达珠宝架子的右下角时，停止拿取</li> 
</ul>

<p>注意：珠宝的价值都是大于 0 的。除非这个架子上没有任何珠宝，比如 <code>frame = [[0]]</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>frame = [[1,3,1],[1,5,1],[4,2,1]]
<strong>输出：</strong><span><code>12
</code></span><strong>解释：</strong>路径 1→3→5→2→1 可以拿到最高价值的珠宝</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>0 &lt; frame.length &lt;= 200</code></li> 
 <li><code>0 &lt; frame[0].length &lt;= 200</code></li> 
</ul>

<p>&nbsp;</p>

<div><div>Related Topics</div><div><li>数组</li><li>动态规划</li><li>矩阵</li></div></div><br><div><li>👍 551</li><li>👎 0</li></div>