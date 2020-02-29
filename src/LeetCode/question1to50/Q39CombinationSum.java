package LeetCode.question1to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q39CombinationSum {
    /**
     *
     * @param candidates 无重复元素数组
     * @param target 相加的和
     * @return 结果列表
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum(candidates, target, 0);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target, int indexStart) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = indexStart; i < candidates.length; i++){
            int targetNext = target - candidates[i];
            if (targetNext == 0){
                List<Integer> resultNew = new ArrayList<>();
                resultNew.add(candidates[i]);
                result.add(resultNew);
            }else if (targetNext < 0){
                break;
            }else{
                for (List<Integer> resultNew: combinationSum(candidates, targetNext, i)) {
                    resultNew.add(candidates[i]);
                    result.add(resultNew);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var x = new Q39CombinationSum();
        System.out.println(x.combinationSum(new int[]{2, 3, 6, 7}, 7).toString());
    }
}
