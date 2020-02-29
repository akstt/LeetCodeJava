package LeetCode.question1to50;

public class Q20ValidParentheses {
    /**
     * 利用堆栈
     * @param s 输入的字符串
     * @return 括号是否匹配
     */
    public boolean isValid(String s) {
        int index = 1;
        char[] parenthesesStack = new char[s.length()+1];
        for (char c:s.toCharArray()){
            if(c == '{' || c == '[' || c == '(' ){
                parenthesesStack[index] = c;
                index ++;
            }else if(c == '}' && parenthesesStack[--index] != '{'){
                return false;
            }
            else if(c == ']' && parenthesesStack[--index] != '['){
                return false;
            }
            else if(c == ')' && parenthesesStack[--index] != '('){
                return false;
            }
        }
        return index == 1;
    }

    public static void main(String[] args) {
        var x = new Q20ValidParentheses();
        System.out.println(x.isValid("()"));
    }
}
