<p>这里有&nbsp;<code>n</code>&nbsp;个一样的骰子，每个骰子上都有&nbsp;<code>k</code>&nbsp;个面，分别标号为&nbsp;<code>1</code>&nbsp;到 <code>k</code> 。</p>

<p>给定三个整数 <code>n</code>、<code>k</code> 和 <code>target</code>，请返回投掷骰子的所有可能得到的结果（共有 <code>k<sup>n</sup></code> 种方式），使得骰子面朝上的数字总和等于 <code>target</code>。</p>

<p>由于答案可能很大，你需要对 <code>10<sup>9</sup> + 7</code> <strong>取模</strong>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 1, k = 6, target = 3
<strong>输出：</strong>1
<strong>解释：</strong>你掷了一个有 6 个面的骰子。
得到总和为 3 的结果的方式只有一种。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 2, k = 6, target = 7
<strong>输出：</strong>6
<strong>解释：</strong>你掷了两个骰子，每个骰子有 6 个面。
有 6 种方式得到总和为 7 的结果: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>n = 30, k = 30, target = 500
<strong>输出：</strong>222616187
<strong>解释：</strong>返回的结果必须对 10<sup>9</sup> + 7 取模。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= n, k &lt;= 30</code></li> 
 <li><code>1 &lt;= target &lt;= 1000</code></li> 
</ul>

<div><div>Related Topics</div><div><li>动态规划</li></div></div><br><div><li>👍 296</li><li>👎 0</li></div>