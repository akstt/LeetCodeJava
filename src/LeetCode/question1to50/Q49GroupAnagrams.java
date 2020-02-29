package LeetCode.question1to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q49GroupAnagrams {

    /**
     *
     * @param strs 字符串数组
     * @return 异位词分组结果
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        List<char[]> lettersAll = new ArrayList<>();
        for1: for (String words: strs){
            char[] letters = new char[words.length()];
            for (int i=0; i < words.length(); i++){
                letters[i] = words.charAt(i);
            }
            Arrays.sort(letters);
            for2: for (int i = 0; i < lettersAll.size(); i++){
                if (lettersAll.get(i).length == letters.length){
                    for (int j = 0; j < letters.length; j++){
                        if (lettersAll.get(i)[j] != letters[j]){
                            continue for2;
                        }
                    }
                    result.get(i).add(words);
                    continue for1;
                }
            }
            List<String> resultToAdd = new ArrayList<>();
            resultToAdd.add(words);
            result.add(resultToAdd);
            lettersAll.add(letters);
        }
        return result;
    }

    public static void main(String[] args) {
        var x = new Q49GroupAnagrams();
        System.out.println(x.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
