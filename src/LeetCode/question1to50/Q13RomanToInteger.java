package LeetCode.question1to50;

import java.util.HashMap;
import java.util.Map;

public class Q13RomanToInteger {
    /**
     * 遍历罗马字符，当前字符比下一个字符小时，结果减去当前字符代表数字，否则加当前字符代表数字
     * @param s 罗马数字
     * @return 数字
     */
    public int romanToInt(String s) {
        Map<Character, Integer> romanToInt = new HashMap<>();
        romanToInt.put('I', 1);
        romanToInt.put('V', 5);
        romanToInt.put('X', 10);
        romanToInt.put('L', 50);
        romanToInt.put('C', 100);
        romanToInt.put('D', 500);
        romanToInt.put('M', 1000);
        int result = 0;
        for (int i = 0; i < s.length(); i ++){
            int num1 = romanToInt.get(s.charAt(i));
            if (i < s.length() - 1){
                int num2 = romanToInt.get(s.charAt(i+1));
                if (num1 < num2){
                    result = result + num2 - num1;
                    i++;
                    continue;
                }
            }
            result += num1;
        }
        return result;
    }

    public static void main(String[] args) {
        var x =new Q13RomanToInteger();
        System.out.println(x.romanToInt("III"));
    }
}
