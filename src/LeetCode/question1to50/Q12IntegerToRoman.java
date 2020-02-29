package LeetCode.question1to50;

public class Q12IntegerToRoman {
    /**
     * 依次取出最大的值numMax，当num < numMax时，将numMax减小；否则num-=numMax，结果添加numMax代表的字符
     * @param num 输入数字
     * @return 罗马字符
     */
    public String intToRoman(int num) {
        String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X","IX", "V", "IV", "I"};
        int[] intMap = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < roman.length; i++){
            while (num >= intMap[i]){
                num -= intMap[i];
                result.append(roman[i]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        var x = new Q12IntegerToRoman();
        x.intToRoman(4);
    }
}
