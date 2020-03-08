package algorithms;

import java.util.*;

// 力扣28题
public class StringMatch {

    /**
     * 朴素算法（暴力匹配算法）
     * 时间复杂度O(n * m)
     * 空间复杂度O(1)
     * @param text 是一个长度为n的字符串
     * @param pattern 是一个长度为m的字符串
     * @return pattern在text第一次出现的索引位置
     */
    public int naiveAlgorithm(String text, String pattern){
        int result = -1;
        for (int indexStringStart = 0; indexStringStart <= text.length() - pattern.length(); indexStringStart ++){
            int indexString = indexStringStart;
            int indexPattern = 0;
            for (; indexPattern < pattern.length(); indexPattern ++,indexString ++){
                if (text.charAt(indexString) != pattern.charAt(indexPattern)){
                    break;
                }
            }
            if (indexPattern == pattern.length()){
                result = indexStringStart;
                break;
            }
        }
        return result;
    }

    /**
     * KMP算法
     * 平均时间复杂度O(n)
     * 空间复杂度O(1)
     * @param text 是一个长度为n的字符串
     * @param pattern 是一个长度为m的字符串
     * @return pattern在text第一次出现的索引位置
     */
    public int KMP(String text, String pattern){
        if (pattern.length() == 0){
            return 0;
        }
        int result = -1;
        // 最长公共前缀后缀
        int[] prefixLength = longestPrefixPostfixKMP(pattern);

        // indexText不会后移，indexPattern会根据最长公共前缀后缀进行后移
        int indexText = 0;
        int indexPattern = 0;
        for (; indexPattern < pattern.length() && indexText < text.length(); ){
            if (text.charAt(indexText) != pattern.charAt(indexPattern)){
                indexPattern = prefixLength[indexPattern];
                if (indexPattern != -1){
                    continue;
                }
            }
            indexPattern ++;
            indexText ++;
        }
        /*
         下面这个循环在力扣28题也能通过测试，但这代码明显错了
         反例text = "abcabdabe"，pattern = "abcabe"
         for (; indexPattern < pattern.length() && indexText < text.length(); indexPattern ++, indexText ++){
            if (text.charAt(indexText) != pattern.charAt(indexPattern)){
                indexPattern = prefixLength[indexPattern];
            }
        }
         */
        if (indexPattern == pattern.length()){
            result = indexText - indexPattern;
        }
        return  result;
    }

    /*
    获得最长相同前缀后缀
     */
    private int[] longestPrefixPostfixKMP(String s){
        int[] result = new int[s.length()];
        result[0] = -1;
        int indexPrefix = -1;
        int indexPostfix = 0;
        while(indexPostfix < s.length() - 1){
            if (indexPrefix == -1 || s.charAt(indexPrefix) == s.charAt(indexPostfix)) {
                indexPrefix ++;
                indexPostfix ++;
                // 这个地方保证前缀后缀的后一个字符是不相同的
                // 所以其实不是最长的相同前缀后缀
                if (s.charAt(indexPrefix) == s.charAt(indexPostfix)){
                    result[indexPostfix] = result[indexPrefix];
                }else {
                    result[indexPostfix] = indexPrefix;
                }
            }else{
                indexPrefix = result[indexPrefix];
            }
        }
        return result;
    }

    /**
     * BM算法
     * 平均时间复杂度O(n)
     * 空间复杂度O(1)
     * @param text 是一个长度为n的字符串
     * @param pattern 是一个长度为m的字符串
     * @return pattern在text第一次出现的索引位置
     */
    public int BM(String text, String pattern){
        int result = -1;
        // 好后缀
        int[] goodPostfix = getGoodPostfix(pattern);
        /*
        //坏字符
        Map<Character, List<Integer>> badChar = new HashMap<>();
        for (int i = pattern.length()-1; i >= 0 ; i--){
            char charTemp = pattern.charAt(i);
            if (badChar.containsKey(charTemp)){
                badChar.get(charTemp).add(i);
            }else{
                List<Integer> listTemp = new ArrayList<>();
                listTemp.add(i);
                badChar.put(charTemp, listTemp);
            }
        }
        */
        int indexTextEnd = pattern.length()-1;
        while (indexTextEnd < text.length()){
            int indexText = indexTextEnd;
            int indexPattern  = pattern.length() - 1;
            for (; indexPattern >= 0; indexPattern --, indexText --){
                if (text.charAt(indexText) != pattern.charAt(indexPattern)){
                    /*
                    BM算法的特点就在于此，选择上述两种启发法规则（坏字符和好后缀）计算结果中最大的一个值来对模式 P 的比较位置进行滑动。
                    我感觉上面这句话不太对
                    我认为应该是坏字符失效时，才会采用好后缀的规则
                     */
                    int indexTextMove = indexPattern + 1;
                    // 坏字符
                    char charTemp = text.charAt(indexText);
                    int indexPatternTemp = indexPattern - 1;
                    for (; indexPatternTemp >= 0; indexPatternTemp--){
                        if (pattern.charAt(indexPatternTemp) == charTemp){
                            indexTextMove = indexPattern - indexPatternTemp;
                            break;
                        }
                    }
                    /*
                    if (badChar.containsKey(charTemp)){
                        for (int badCharIndex: badChar.get(charTemp)){
                            if (badCharIndex < indexPattern){
                                indexTextMove = indexPattern - badCharIndex;
                                break;
                            }
                        }
                    }
                    */
                    // 好后缀
                    if (indexTextMove == indexPattern + 1){
                        indexTextMove = pattern.length();
                        for (int indexPostfix : goodPostfix){
                            if (indexPostfix > indexPattern){
                                indexTextMove = indexPostfix;
                                break;
                            }
                        }
                    }

                    indexTextEnd += indexTextMove;
                    break;
                }
            }
            if (indexPattern == -1){
                result = indexText + 1;
                break;
            }
        }
        return result;
    }

    /*
    获得所有好后缀的索引位置，和获得（真）最长相同前缀后缀思路类似
     */
    private int[] getGoodPostfix(String s){
        int[] result = new int[s.length() + 1];
        result[0] = -1;
        int indexPrefix = -1;
        int indexPostfix = 0;
        while(indexPostfix < s.length()){
            if (indexPrefix == -1 || s.charAt(indexPrefix) == s.charAt(indexPostfix)){
                indexPrefix ++;
                indexPostfix ++;
                result[indexPostfix] = indexPrefix;
            }else{
                indexPrefix = result[indexPrefix];
            }
        }
        int postfixCount = result.length;
        int postfixLength = result[s.length()];
        while (postfixLength > 0){
            postfixCount --;
            result[postfixCount] = s.length() - postfixLength;
            postfixLength = result[postfixLength];
        }
        int[] postfixIndex = new int[result.length - postfixCount];
        for (int i = 0; i < postfixIndex.length; i++){
            postfixIndex[i] = result[s.length()-i];
        }
        return postfixIndex;
    }

    /**
     * Sunday算法
     * 平均时间复杂度O(n)
     * 空间复杂度O(1)
     * @param text 是一个长度为n的字符串
     * @param pattern 是一个长度为m的字符串
     * @return pattern在text第一次出现的索引位置
     */
    public int Sunday(String text, String pattern){
        int result = -1;
        // 字符出现的最右侧的索引 (这里如果用数组代替字典，可能会快一些)
        Map<Character, Integer> charRightmostIndex = new HashMap<>();
        for (int i = 0; i < pattern.length(); i ++){
            charRightmostIndex.put(pattern.charAt(i), pattern.length() - i);
        }

        int indexTextStart = 0;
        while (indexTextStart <= text.length() - pattern.length()){
            int indexText = indexTextStart;
            int indexPattern = 0;
            for (; indexPattern < pattern.length(); indexPattern ++, indexText++){
                if (text.charAt(indexText) != pattern.charAt(indexPattern)){
                    int indexCharLast = indexTextStart + pattern.length();
                    if (indexCharLast < text.length() && charRightmostIndex.containsKey(text.charAt(indexCharLast))){
                        indexTextStart += charRightmostIndex.get(text.charAt(indexCharLast));
                    }else{
                        indexTextStart += pattern.length() + 1;
                    }
                    break;
                }
            }
            if (indexPattern == pattern.length()){
                result = indexTextStart;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var x = new StringMatch();
        String text = "abcabcabe";
        String pattern = "abcabe";
        System.out.println(x.BM(text, pattern));
    }
}
