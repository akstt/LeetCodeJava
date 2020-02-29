package LeetCode.question1to50;

public class Q08StringToInteger {
    public int myAtoi(String str) {
        int result = 0;
        int i = 0;
        int flag = 1;
        while (i < str.length() && str.charAt(i) == ' '){
            i++;
        }
        if (i < str.length() && str.charAt(i) == '-'){
            flag = -1;
            i++;
        }else if(i < str.length() && str.charAt(i) == '+'){
            i++;
        }
        char sign;
        int maxInt = Integer.MAX_VALUE/10;
        while (i < str.length()){
            sign = str.charAt(i);
            if (48<= sign && sign <= 57){
                if (result > maxInt || result == maxInt && sign > 55) {
                    return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }else {
                    result = result * 10 + sign - 48;
                }
            }else{
                break;
            }
            i++;
        }
        return result * flag;
    }

    public static void main(String[] args) {
        String str = " -1010023630o4";
        var x= new Q08StringToInteger();
        System.out.println(x.myAtoi(str));


    }
}
