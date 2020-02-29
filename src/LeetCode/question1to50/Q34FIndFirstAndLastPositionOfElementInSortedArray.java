package LeetCode.question1to50;

import java.util.Arrays;

public class Q34FIndFirstAndLastPositionOfElementInSortedArray {
    /**
     *
     * @param nums 数组
     * @param target 需要找到的数字
     * @return 数字的范围
     */
    public int[] searchRange(int[] nums, int target) {
        int indexStart = 0, indexEnd = nums.length - 1, indexMiddle = 0;
        int[] result = new int[]{-1, -1};
        while (indexStart <= indexEnd){
            indexMiddle = (indexStart + indexEnd)/2;
            if (nums[indexMiddle] > target){
                indexEnd = indexMiddle - 1;
            }else if (nums[indexMiddle] < target){
                indexStart = indexMiddle + 1;
            }else{
                result[0] = searchLeft(nums, target, 0, indexMiddle);
                result[1] = searchRight(nums, target, indexMiddle, nums.length-1);
                return result;
            }
        }
        return result;
    }

    /*
    寻找左边界
     */
    public int searchLeft(int[] nums, int target, int indexStart, int indexEnd){
        int indexMiddle = indexEnd;
        while (indexStart <= indexEnd){
            if (indexStart == indexEnd){
                return indexStart;
            }
            indexMiddle = (indexStart + indexEnd)/2;
            if (nums[indexMiddle] < target){
                indexStart = indexMiddle + 1;
            }else{
                indexEnd = indexMiddle;
            }
        }
        return indexMiddle;
    }

    /*
    寻找右边界
     */
    public int searchRight(int[] nums, int target, int indexStart, int indexEnd){
        int indexMiddle = indexStart;
        while (indexStart <= indexEnd){
            if (indexStart == indexEnd){
                return indexStart;
            }
            indexMiddle =(int) Math.ceil((indexStart + indexEnd)/2.0);
            if (nums[indexMiddle] > target){
                indexEnd = indexMiddle - 1;
            }else{
                indexStart = indexMiddle;
            }
        }
        return indexMiddle;
    }

    public static void main(String[] args) {
        var x = new Q34FIndFirstAndLastPositionOfElementInSortedArray();
        System.out.println(Arrays.toString(x.searchRange(new int[]{2, 2}, 2)));
    }
}
