package LeetCode.question1to50;

public class Q28ImplementStrStr {
    /**
     *
     * @param haystack 长字符串
     * @param needle 需要在haystack找到的子串
     * @return 长字符串中子串索引位置
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0){
            return 0;
        }

        int length = haystack.length() - needle.length() + 1;
        first: for (int i = 0; i < length; i++){
            int i1 = i;
            for (int j = 0; j < needle.length(); j++){
                if (haystack.charAt(i1) != needle.charAt(j)){
                    continue first;
                }else{
                    i1++;
                }

            }
            return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        var x = new Q28ImplementStrStr();
        x.strStr("hello", "ll");
    }
}
