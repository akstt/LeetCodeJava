package LeetCode.question1to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q47PermutationsTwo {
    /**
     *
     * @param nums 有重复数字的序列
     * @return 不重复的全排列
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int nullValue = nums[0] - 1;
        return permuteUnique(nums, nullValue);
    }

    public List<List<Integer>> permuteUnique(int[] nums, int nullValue){
        List<List<Integer>> result = new ArrayList<>();
        int numTemp = nullValue;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == nullValue || nums[i] == numTemp){
                continue;
            }
            numTemp = nums[i];
            int[] numsTemp = nums.clone();
            numsTemp[i] = nullValue;
            List<List<Integer>> resultToAddAll = permuteUnique(numsTemp, nullValue);
            if (resultToAddAll.size() == 0){
                List<Integer> result1 = new ArrayList<>();
                result1.add(nums[i]);
                result.add(result1);
            }else{
                for (List<Integer> result1: resultToAddAll){
                    result1.add(nums[i]);
                    result.add(result1);
                }
            }
        }
        return result;
    }
}
