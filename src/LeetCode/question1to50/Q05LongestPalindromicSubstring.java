package LeetCode.question1to50;

public class Q05LongestPalindromicSubstring {

    // Manacher算法
    // 时间复杂度为O(n), 新建立字符串，空间复杂度为O(n)
    public String longestPalindrome(String s) {
        // 建立新字符串
        StringBuilder newStringBuilder = new StringBuilder();
        newStringBuilder.append("#");
        for (int i = 0; i < s.length(); i++) {
            newStringBuilder.append(s.charAt(i)).append("#");
        }
        String newString = newStringBuilder.toString();
        System.out.println(newString);
        // 存储回文子串长度半径
        int[] substringLength = new int[newString.length()];
        int maxLength = 0;
        int middle = 0;
        int right = 0;
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < newString.length(); i++) {
            if (i < right) {
                substringLength[i] = (right - i) < substringLength[2 * middle - i] ?
                        (right - i) : substringLength[2 * middle - i];
            }
            while (i-substringLength[i] >=0 && i + substringLength[i] < newString.length() &&
                    newString.charAt(i-substringLength[i]) == newString.charAt(i+substringLength[i])){
                substringLength[i]++;
            }
            if (i + substringLength[i] > right){
                middle = i;
                right = i + substringLength[i];
            }
            if (substringLength[i] > maxLength){
                maxLength = substringLength[i];
                startIndex = (i-substringLength[i]+1)/2;
                endIndex = (i+substringLength[i]-1)/2;
            }
        }
        return s.substring(startIndex, endIndex);
    }

    public static void main(String[] args) {
        var x = new Q05LongestPalindromicSubstring();
        var s = "babad";
        System.out.println(x.longestPalindrome(s));
    }
}
