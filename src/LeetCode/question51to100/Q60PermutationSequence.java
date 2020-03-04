package LeetCode.question51to100;

import java.util.ArrayList;
import java.util.List;

public class Q60PermutationSequence {

    // 阶乘判断需要几位数字能到达k，然后将数字放入到应该的地方
    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();
        int index = 1;
        int num = 1;
        while (k > num){
            num *= ++index ;
        }
        for (int i = 1; i <= n-index; i ++){
            result.append(i);
        }
        List<Integer> numOther = new ArrayList<>();
        for (int i = n - index + 1; i <= n; i ++){
            numOther.add(i);
        }
        k --;
        while (index >= 1){
            num /= index --;
            result.append(numOther.remove(k/num));
            k %= num;
        }
    return result.toString();
    }

    public static void main(String[] args) {
        var x = new Q60PermutationSequence();
        System.out.println(x.getPermutation(4, 9));
    }
}
