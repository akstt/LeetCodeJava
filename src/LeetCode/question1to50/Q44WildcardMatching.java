package LeetCode.question1to50;

public class Q44WildcardMatching {
    /**
     *
     * @param s 字符串
     * @param p 字符模式
     * @return 是否匹配
     */
    public boolean isMatch(String s, String p) {
        boolean[][] result = new boolean[s.length() + 1][p.length() + 1];
        result[s.length()][p.length()] = true;
        for (int i = s.length(); i >=0; i--){
            for (int j = p.length()-1; j >=0; j--){
                if (p.charAt(j) == '*'){
                    result[i][j] = result[i][j+1] || (i < s.length() && result[i+1][j+1]) || (i < s.length() && result[i+1][j]);
                }else{
                    boolean ifMatch = (p.charAt(j) == '?' || (i < s.length() && s.charAt(i) == p.charAt(j)));
                    result[i][j] = (ifMatch && i < s.length() && result[i+1][j+1]);
                }
            }
        }
        return result[0][0];

    }

    public static void main(String[] args) {
        var x = new Q44WildcardMatching();
        System.out.println(x.isMatch("aa", "*"));
    }
}
