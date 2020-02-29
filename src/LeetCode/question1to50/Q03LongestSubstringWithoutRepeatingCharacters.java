package LeetCode.question1to50;

import java.util.HashMap;
import java.util.Map;

public class Q03LongestSubstringWithoutRepeatingCharacters {

    //时间复杂度为O(n)， 空间复杂度为O(n)
    public int lengthOfLongestSubstring(String s) {
        // 建立HashMap,
        // key是字符串中的字符，value是当前索引之前，各字符的索引位置
        Map<Character, Integer> substringIndex = new HashMap<>();
        // startIndex：子串的起始位置
        int startIndex = -1;
        // 子串最长长度
        int longest = 0;
        for (int i=0; i<s.length(); i++){
            char sign = s.charAt(i);
            int signIndex = substringIndex.getOrDefault(sign, -1);
            // signIndex > startIndex说明该字符已经出现在子串中了，则startIndex = signIndex，删除子串中重复的字符
            if (signIndex > startIndex){
                startIndex = signIndex;
            }else{
                // 更新最大长度
                longest = longest > i-startIndex ? longest : i-startIndex;
                // longest = Math.max(longest, i - startIndex);
            }
            substringIndex.put(sign, i);
        }
        return longest;
    }

    public static void main(String[] args) {
        var string = "pwwkew";
        var s = new Q03LongestSubstringWithoutRepeatingCharacters();
        System.out.println(s.lengthOfLongestSubstring(string));
    }
}
