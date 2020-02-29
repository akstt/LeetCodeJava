package LeetCode.question1to50;

public class Q10RegularExpressionMatching {
    /**
     * Description 动态规划
     * @param s 字符串
     * @param p 字符规律
     * @return 是否匹配
     */
    public boolean isMatch1(String s, String p) {
        boolean[][] match_result = new boolean[s.length() + 1][p.length() + 1];
        match_result[s.length()][p.length()] = true;
        for (int i = s.length(); i >= 0; i --){
            for (int j = p.length()-1; j >= 0; j--){
                boolean if_match = i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j));
                if (j + 1 < p.length() && p.charAt(j+1) == '*'){
                    match_result[i][j] = match_result[i][j+2] || (if_match && match_result[i+1][j]);
                }else{
                    match_result[i][j] = if_match && match_result[i+1][j+1];
                }
            }
        }
        return match_result[0][0];
    }

    /**
     * Description 回溯法
     * @param s 字符串
     * @param p 字符规律
     * @return 是否匹配
     */
    public boolean isMatch2(String s, String p) {
        return isMatch2(s, p, 0, 0);
    }

    private boolean isMatch2(String s, String p, int i, int j){
        if (j == p.length()){
            return i == s.length();
        }
        boolean if_match = i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j));
        if(j + 1 < p.length() && p.charAt(j+1) == '*'){
            return isMatch2(s, p, i, j+2) || (if_match && isMatch2(s, p, i + 1, j));
        }else{
            return if_match && isMatch2(s, p, i +1, j+1);
        }
    }

    public static void main(String[] args) {
        var a = new Q10RegularExpressionMatching();
        System.out.println(a.isMatch2("aa", "a*"));
    }
}
