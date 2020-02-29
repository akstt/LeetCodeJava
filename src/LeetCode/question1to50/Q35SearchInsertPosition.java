package LeetCode.question1to50;

public class Q35SearchInsertPosition {
    /**
     *
     * @param nums 排序数组
     * @param target 插入数值
     * @return 插入索引
     */
    public int searchInsert(int[] nums, int target) {
        int indexStart=0, indexEnd = nums.length-1, indexMiddle;
        while (indexStart <= indexEnd){
            indexMiddle = (indexStart + indexEnd) /2;
            if (nums[indexMiddle] > target){
                indexEnd = indexMiddle - 1;
            }else if (nums[indexMiddle] < target){
                indexStart = indexMiddle + 1;
            }else{
                return indexMiddle;
            }

        }
        return indexStart;
    }
}
