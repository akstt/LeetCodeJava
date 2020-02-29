package LeetCode.question1to50;

public class Q43MultiplyStrings {
    /**
     *
     * @param num1 整数字符串形式
     * @param num2 整数字符串形式
     * @return 相乘结果
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0")|| num2.equals("0")){
            return "0";
        }
        StringBuilder result = new StringBuilder();
        int numTemp = 0;
        for (int i = num1.length() + num2.length()-2; i >= 0; i--){
            int numTemp1 = 0;
            for (int j = 0; j < Math.min(num1.length(), i + 1); j ++){
                int k = i - j;
                if (k < num2.length()){
                    numTemp1 += (num1.charAt(j) - '0') * (num2.charAt(k) - '0');
                }
            }
            numTemp1 += numTemp;
            result.append(numTemp1%10);
            numTemp = numTemp1 /10;
        }
        if (numTemp != 0){
            result.append(numTemp);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        var x = new Q43MultiplyStrings();
        System.out.println(x.multiply("0", "456"));
    }
}
