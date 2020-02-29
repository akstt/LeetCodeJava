package LeetCode.question1to50;

public class Q07ReverseInteger {
    public int reverse(int x) {
//        String xString;
//        if (x<0){
//            xString = String.valueOf(-x);
//            xString += "-";
//        }else{
//            xString = String.valueOf(x);
//        }
//        xString = new StringBuilder(xString).reverse().toString();
//        try{
//            return Integer.parseInt(xString);
//        }catch (NumberFormatException e1){
//            return 0;
//        }
        int xReverse = 0;
        int maxInt = Integer.MAX_VALUE/10;
        int minInt = Integer.MIN_VALUE/10;
        while (x != 0){
            if (xReverse > maxInt || xReverse < minInt){
                return 0;
            }
            xReverse = xReverse * 10 + x % 10;
            x /= 10;
        }
        return xReverse;

    }

    public static void main(String[] args) {
        int x = -2147483412;
        Q07ReverseInteger a = new Q07ReverseInteger();
        System.out.println(a.reverse(x));
        System.out.println(-123%10);
    }
}
