package LeetCode.question1to50;

public class Q06ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        int front = 1;
        int charIndex = 0;
        int[] numIndex = new int[numRows];
        char[][] charNewOrder = new char[numRows][s.length()/(numRows-1)];
        for(int i= 0; i<s.length(); i++){
            charNewOrder[charIndex][numIndex[charIndex]] = s.charAt(i);
            numIndex[charIndex] ++;
            if (charIndex==0){
                front = 1;
            }else if(charIndex == numRows-1){
                front = -1;
            }
            charIndex += front;
        }
        StringBuilder newString = new StringBuilder();
        for (int i=0; i<numRows; i++){
            for (int j=0; j<numIndex[i];j++)
                newString.append(charNewOrder[i][j]);
        }
        return newString.toString();
    }

    public static void main(String[] args) {
        var s = "PAYPALISHIRING";
        var numRows = 3;
        var x= new Q06ZigZagConversion();
        System.out.println(x.convert(s, numRows));
    }
}
