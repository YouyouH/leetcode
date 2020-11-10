function extracted(strs, lenth, shortest) {
    for (const str of strs) {
        if (str.length < lenth) {
            lenth = str.length;
        }
    }
    for (const str of strs) {
        if (str.length === lenth) {
            shortest.push(str);
        }
    }
}

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function (strs) {
    if (strs === undefined || strs.length === 0)
        return "";
    //最长公共前缀不大于最短str
    const shortest = [];

    const length = strs[0].length;

    extracted(strs, length, shortest);
    const longestPrefixArray = [];
    for (const shortestElement of shortest) {
        const longestPrefix = [];
        for (let i = 0; i < length; i++) {
            const element = shortestElement.charAt(i);
            let flag = true;
            for (const str of strs) {
                if (str.charAt(i) !== element) {
                    flag = false;
                    break;
                }
            }
            if (flag === true) {
                longestPrefix.push(element);
            } else {
                longestPrefixArray.push(longestPrefix);
                break;
            }
        }
        longestPrefixArray.push(longestPrefix);
    }
    if (longestPrefixArray.length === 0) {
        return "";
    }
    return longestPrefixArray.reduce(function (a, b) {
        return a.length > b.length ? a : b;
    }).join("");


};

console.log(longestCommonPrefix(["aa", "ab", "aad", "aabc"]));
console.log(longestCommonPrefix(["flower", "flow", "flight"]));
console.log(longestCommonPrefix([""]));
console.log(longestCommonPrefix(["a"]));

