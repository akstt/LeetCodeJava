package LeetCode.question1to50;

public class Q32LongestValidParentheses {
    /**
     *
     * @param s 长字符串
     * @return 最长括号长度
     */
    public int longestValidParentheses(String s) {
//        int result = 0, leftNum = 0, rightNum=0, result_temp = 0;
//        for (int i = 0; i < s.length(); i ++){
//            if (s.charAt(i) == '('){
//                leftNum ++;
//            }else{
//                rightNum ++;
//            }
//            if (leftNum < rightNum){
//                leftNum = 0;
//                rightNum = 0;
//                result_temp = 0;
//            }else if(leftNum == rightNum){
//                result_temp += leftNum * 2;
//                result = Math.max(result, result_temp);
//                leftNum = 0;
//                rightNum = 0;
//            }else{
//                result = Math.max(result, rightNum * 2);
//            }
//        }
//        return result;
        int result = 0, resultTemp = 0;
        int[] resultArray = new int[s.length()];
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == ')'){
                if (s.charAt(i - 1) == '('){
                    if ((i-2) >= 0){
                        resultTemp = resultArray[i-2] + 2;
                    }else{
                        resultTemp = 2;
                    }
                }else{
                    if (i - 1 - resultArray[i-1] >= 0 && s.charAt(i - 1 - resultArray[i-1]) == '('){
                        resultTemp = resultArray[i-1] + 2;
                        if (i - 1 - resultArray[i-1]-1 >= 0){
                            resultTemp += resultArray[i - 1 - resultArray[i-1]-1];
                        }
                    }else{
                        resultTemp = 0;
                    }
                }
                resultArray[i] = resultTemp;
                result = Math.max(result, resultTemp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var x = new Q32LongestValidParentheses();
        System.out.println(x.longestValidParentheses("(()())"));
    }
}
