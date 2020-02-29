package LeetCode.question1to50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q17LetterCombinationsOfAPhoneNumber {
//    static final Map<Character, String> NUMTOLETTER= Map.of('2', "abc", '3', "def", '4', "ghi", '5',"jkl",
//            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    /**
     * 递归解决
     * @param digits 输入数字
     * @return 返回的组合字符串列表
     */
    public List<String> letterCombinations(String digits) {
        Map<Character, String> NumToLetter =new HashMap<>();
        NumToLetter.put('2', "abc");
        NumToLetter.put('3', "def");
        NumToLetter.put('4', "ghi");
        NumToLetter.put('5',"jkl");
        NumToLetter.put('6', "mno");
        NumToLetter.put('7', "pqrs");
        NumToLetter.put('8', "tuv");
        NumToLetter.put('9', "wxyz");
        if (digits.length() == 0){
            return new ArrayList<>();
        }
        return letterCombinations(NumToLetter, digits, 0);

    }

    public List<String> letterCombinations(Map<Character, String> NumToLetter, String digits, int index_1){
        List<String> result = new ArrayList<>();
        String letters = NumToLetter.get(digits.charAt(index_1));
        if (index_1 == digits.length()-1) {
            for (int i = 0; i < letters.length(); i++) {
                result.add(String.valueOf(letters.charAt(i)));
            }
        }
        else{
            for (int i = 0; i < letters.length(); i++){
                for(String s: letterCombinations(NumToLetter, digits, index_1 + 1)){
                    result.add(letters.charAt(i) + s);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        var x = new Q17LetterCombinationsOfAPhoneNumber();
        System.out.println(x.letterCombinations("23"));;

    }
}
