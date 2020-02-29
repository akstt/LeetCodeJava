package LeetCode.question1to50;

public class Q14LongestCommonPrefix {
    /**
     * 遍历字符串列表，逐一比较字符串最长子串
     * @param strings 字符串列表
     * @return 最长公共子串
     */
    public String longestCommonPrefix(String[] strings) {
        if (strings.length == 0){
            return "";
        }
        String commonPrefix = strings[0];
        for (String stringTemp: strings){
            int i= 0;
            for(; i<commonPrefix.length() && i < stringTemp.length(); i ++){
                if (commonPrefix.charAt(i) != stringTemp.charAt(i)){
                    commonPrefix = commonPrefix.substring(0, i);
                    break;
                }
            }
            commonPrefix = commonPrefix.substring(0, i);

        }
        return commonPrefix;
    }

    public static void main(String[] args) {
        var a = new String[]{"flower","flow","flight"};
        var x = new Q14LongestCommonPrefix();
        System.out.println(x.longestCommonPrefix(a));
    }
}
