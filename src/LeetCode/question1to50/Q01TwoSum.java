package LeetCode.question1to50;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q01TwoSum {

//    时间复杂度为O(n), 空间复杂度为O(n)
    public int[] twoSum(int[] nums, int target) {
        // 建立HashMap
        Map<Integer, Integer> indexMatchNum = new HashMap<>();
        for (var i = 0; i < nums.length; i++){
            // 如果当前数字在indexMatchNum的keys中则代表找到配对数字
            if (indexMatchNum.containsKey(nums[i])){
                return new int[]{indexMatchNum.get(nums[i]), i};
            }else {
                // key是当前循环中数字需要配对的数字
                // val是当前循环中数字的索引
                indexMatchNum.put(target - nums[i], i);
            }
        }
        return new int[]{-1, -1};


    }

    public static void main(String[] args) {
        var solution = new Q01TwoSum();
        var nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}
