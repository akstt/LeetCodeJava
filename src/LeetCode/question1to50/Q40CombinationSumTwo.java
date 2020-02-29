package LeetCode.question1to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40CombinationSumTwo {
    /**
     *
     * @param candidates 无重复元素数组
     * @param target 相加的和
     * @return 结果列表
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum2(candidates, target, 0);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target, int indexStart) {
        List<List<Integer>> result = new ArrayList<>();
        int numTemp = candidates[0] -1;
        for (int i = indexStart; i < candidates.length; i++){
            if (candidates[i] == numTemp){
                continue;
            }
            numTemp = candidates[i];
            int targetNext = target - candidates[i];
            if (targetNext == 0){
                List<Integer> resultNew = new ArrayList<>();
                resultNew.add(candidates[i]);
                result.add(resultNew);
            }else if (targetNext < 0){
                break;
            }else{

                for (List<Integer> resultNew: combinationSum2(candidates, targetNext, i+1)) {
                    resultNew.add(candidates[i]);
                    result.add(resultNew);
                }
            }
        }
        return result;
    }
}
