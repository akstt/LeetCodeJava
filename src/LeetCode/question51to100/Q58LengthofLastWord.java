package LeetCode.question51to100;

public class Q58LengthofLastWord {
    // 从后往前找就好了
    public int lengthOfLastWord(String s) {
        int indexStart = s.length()-1;
        for (; indexStart >= 0; indexStart--){
            if (s.charAt(indexStart) != ' '){
                break;
            }
        }
        int indexEnd = indexStart;
        for (; indexEnd >= 0; indexEnd--){
            if (s.charAt(indexEnd) == ' '){
                break;
            }
        }
        return indexStart - indexEnd;
    }

    public static void main(String[] args) {
        var x = new Q58LengthofLastWord();
        System.out.println(x.lengthOfLastWord("Hello World"));
    }
}
