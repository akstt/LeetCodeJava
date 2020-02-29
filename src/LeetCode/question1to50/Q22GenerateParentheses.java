package LeetCode.question1to50;

import java.util.ArrayList;
import java.util.List;

public class Q22GenerateParentheses {
    /**
     * 利用递归解决，穷举所有可能
     * @param n 括号数量
     * @return 有效的括号组合
     */
    public List<String> generateParenthesis(int n) {
        return generateParenthesis(n, 0);
    }

    /**
     * 递归部分
     * @param n 可以放置的左括号数量
     * @param m 可以放置的右括号数量
     * @return 有效的括号组合
     */
    public List<String> generateParenthesis(int n, int m) {
        List<String> result = new ArrayList<>();
        if (n == 0){
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < m; i++){
                s.append(')');
            }
            result.add(s.toString());
        }else{
            for (String s :generateParenthesis(n-1, m + 1)){
                result.add("(" + s);
            }
            if (m > 0){
                for (String s :generateParenthesis(n, m - 1)){
                    result.add(")" + s);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var x = new Q22GenerateParentheses();
        System.out.println(x.generateParenthesis(3));
    }
}
