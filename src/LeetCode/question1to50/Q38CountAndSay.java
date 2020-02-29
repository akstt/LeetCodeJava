package LeetCode.question1to50;

public class Q38CountAndSay {
    /**
     *
     * @param n
     * @return 外观数列第n行
     */
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++){
            StringBuilder stringTemp = new StringBuilder();
            char charTemp = result.charAt(0);
            int numTemp = 1;
            for (int j = 1; j < result.length(); j++){
                if (result.charAt(j) == charTemp){
                    numTemp += 1;
                }else{
                    stringTemp.append(numTemp);
                    stringTemp.append(charTemp);
                    charTemp = result.charAt(j);
                    numTemp = 1;
                }
            }
            stringTemp.append(numTemp);
            stringTemp.append(charTemp);
            result = stringTemp.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        var x= new Q38CountAndSay();
        System.out.println(x.countAndSay(5));
    }

}
