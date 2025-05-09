<p>给定一个字符串&nbsp;<code>s</code><strong>&nbsp;</strong>和一个字符串数组&nbsp;<code>words</code><strong>。</strong>&nbsp;<code>words</code>&nbsp;中所有字符串 <strong>长度相同</strong>。</p>

<p>&nbsp;<code>s</code><strong>&nbsp;</strong>中的 <strong>串联子串</strong> 是指一个包含&nbsp;&nbsp;<code>words</code>&nbsp;中所有字符串以任意顺序排列连接起来的子串。</p>

<ul> 
 <li>例如，如果&nbsp;<code>words = ["ab","cd","ef"]</code>， 那么&nbsp;<code>"abcdef"</code>，&nbsp;<code>"abefcd"</code>，<code>"cdabef"</code>，&nbsp;<code>"cdefab"</code>，<code>"efabcd"</code>， 和&nbsp;<code>"efcdab"</code> 都是串联子串。&nbsp;<code>"acdbef"</code> 不是串联子串，因为他不是任何&nbsp;<code>words</code>&nbsp;排列的连接。</li> 
</ul>

<p>返回所有串联子串在&nbsp;<code>s</code><strong>&nbsp;</strong>中的开始索引。你可以以 <strong>任意顺序</strong> 返回答案。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "barfoothefoobarman", words = ["foo","bar"]
<strong>输出：</strong><span><code>[0,9]</code></span>
<strong>解释：</strong>因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
输出顺序无关紧要。返回 [9,0] 也是可以的。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
<span><code><strong>输出：</strong>[]</code></span>
<strong>解释：</strong>因为<strong> </strong>words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
所以我们返回一个空数组。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
<strong>输出：</strong>[6,9,12]
<strong>解释：</strong>因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>1 &lt;= words.length &lt;= 5000</code></li> 
 <li><code>1 &lt;= words[i].length &lt;= 30</code></li> 
 <li><code>words[i]</code>&nbsp;和&nbsp;<code>s</code> 由小写英文字母组成</li> 
</ul>

<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>滑动窗口</li></div></div><br><div><li>👍 1188</li><li>👎 0</li></div>