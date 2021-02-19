package hash

import "strings"

/**
给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

示例1:

输入: pattern = "abba", str = "dog cat cat dog"
输出: true

示例 2:

输入:pattern = "abba", str = "dog cat cat fish"
输出: false

示例 3:

输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false

示例 4:

输入: pattern = "abba", str = "dog dog dog dog"
输出: false

说明:
你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-pattern
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
func wordPattern(pattern string, s string) bool {
	//双向绑定
	words := strings.Split(s, " ")
	length := len(pattern)
	if length != len(words) {
		return false
	}
	p2w := make(map[string]string)
	w2p := make(map[string]string)

	for i := 0; i < length; i++ {
		p := pattern[i]
		if val, ok := p2w[string(p)]; ok {
			if words[i] != val {
				return false
			}
		} else {
			p2w[string(p)] = words[i]
		}

		if val, ok := w2p[words[i]]; ok {
			if string(p) != val {
				return false
			}
		} else {
			w2p[words[i]] = string(p)
		}
	}
	return true
}
