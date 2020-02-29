package LeetCode.question1to50;

import java.util.*;

public class Q30SubstringWithConcatenationOfAllwords {

    /**
     * @param s 长字符串
     * @param words word数组
     * @return 所有可以构成排列索引
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if (s.length() == 0 || words.length == 0){
            return result;
        }
        int wordLength = words[0].length();
        int wordsLength = wordLength * words.length;
        for (int i = 0; i < wordLength; i++){
            result.addAll(findSubstring(s, words, i, wordLength, wordsLength));
        }
        return result;
    }

    /**
     * 挺麻烦，既要考虑子字符串起始索引的不同情况，而且words中元素不是唯一的
     * @param s 长字符串
     * @param words word数组
     * @param indexStart 长字符串的起始索引
     * @param wordLength word长度
     * @param wordsLength 结果子串长度
     * @return 所有可以构成排列索引
     */
    public List<Integer> findSubstring(String s, String[] words, int indexStart, int wordLength, int wordsLength) {
        Map<String, Deque<Integer>> wordsIndex = new HashMap<>();
        for (String word: words){
            if (!wordsIndex.containsKey(word)){
                wordsIndex.put(word, new ArrayDeque<>());
            }
            wordsIndex.get(word).addFirst(indexStart-1);
        }
        List<Integer> result = new ArrayList<>();
        for(int i = indexStart, j = indexStart+wordLength; j <= s.length();){
            String word = s.substring(i,j);
            if (wordsIndex.containsKey(word)){
                Deque<Integer> wordIndex = wordsIndex.get(word);
                if (wordIndex.getLast() >= indexStart){
                    indexStart = wordIndex.getLast() + wordLength;
                }
                wordIndex.removeLast();
                wordIndex.addFirst(i);
                if ((j - indexStart) == wordsLength){
                    result.add(indexStart);
                    indexStart += wordLength;
                }
            }else{
                indexStart = j;
            }
            i = j;
            j += wordLength;
        }
        return result;
    }

    public static void main(String[] args) {
        var words = new String[]{"word","good","best","word"};

        var s = "goodgoodgoodbestword";
        var x = new Q30SubstringWithConcatenationOfAllwords();
        System.out.println(x.findSubstring(s, words));
    }
}
