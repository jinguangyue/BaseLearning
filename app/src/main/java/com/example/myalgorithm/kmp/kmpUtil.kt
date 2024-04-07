package com.example.myalgorithm.kmp

class kmpUtil {
}

fun main() {



}


/**
 * kmp 寻找匹配串
 *
 * @param text
 * @param pattern
 * @return
 */
fun kmpSearch(text: String, pattern: String): Int {
    val partialMatchTable = buildPartialMatchTable(pattern)
    var textIndex = 0 // 指向文本串
    var patternIndex = 0 // 指向模式串
    while (textIndex < text.length) {
        if (text[textIndex] == pattern[patternIndex]) {
            if (patternIndex == pattern.length - 1) {
                return textIndex - patternIndex // 找到匹配，返回匹配的起始位置
            }
            textIndex++
            patternIndex++
        } else {
            if (patternIndex != 0) {
                patternIndex = partialMatchTable[patternIndex - 1] // 回退到部分匹配表的值
            } else {
                textIndex++
            }
        }
    }
    return -1 // 未找到匹配
}

/**
 * 构建匹配串
 *
 * @param pattern
 * @return
 */
fun buildPartialMatchTable(pattern: String): IntArray {
    val table = IntArray(pattern.length)
    var lengthOfPreviousLongestPrefixSuffix = 0 // 用于记录前一个位置的最长相同前缀后缀的长度
    for (i in 1 until pattern.length) {
        while (lengthOfPreviousLongestPrefixSuffix > 0
            && pattern[i] != pattern[lengthOfPreviousLongestPrefixSuffix]
        ) {
            lengthOfPreviousLongestPrefixSuffix =
                table[lengthOfPreviousLongestPrefixSuffix - 1] // 回退到前一个位置的最长相同前缀后缀的长度
        }
        if (pattern[i] == pattern[lengthOfPreviousLongestPrefixSuffix]) {
            lengthOfPreviousLongestPrefixSuffix++ // 找到相同的字符，增加最长相同前缀后缀的长度
        }
        table[i] = lengthOfPreviousLongestPrefixSuffix
    }
    return table
}

