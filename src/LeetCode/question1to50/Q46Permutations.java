package LeetCode.question1to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q46Permutations {

    /**
     *
     * @param nums 没有重复数字的序列
     * @return 全排列
     */
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        int nullValue = nums[0] - 1;
        return permute(nums, nullValue);
    }

    public List<List<Integer>> permute(int[] nums, int nullValue){
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == nullValue){
                continue;
            }
            int[] numsTemp = nums.clone();
            numsTemp[i] = nullValue;
            List<List<Integer>> resultToAddAll = permute(numsTemp, nullValue);
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

    public static void main(String[] args) {
        var x = new Q46Permutations();
        System.out.println(x.permute(new int[]{1,2,3}));
    }
}
