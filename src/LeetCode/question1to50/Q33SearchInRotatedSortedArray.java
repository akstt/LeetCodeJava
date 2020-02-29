package LeetCode.question1to50;

public class Q33SearchInRotatedSortedArray {
    /**
     *
     * @param nums 旋转过一次的数组
     * @param target 需要寻找的数字
     * @return target的index
     */
    public int search(int[] nums, int target) {
        int indexStart = 0, indexEnd = nums.length-1, indexMiddle=0;
        int indexRotated = 0;
        while(indexStart <= indexEnd){
            indexMiddle = (indexStart + indexEnd)/2;
            if (nums[indexStart] <= nums[indexMiddle]){
                indexStart = indexMiddle + 1;
                if (indexStart < nums.length && nums[indexStart] < nums[indexMiddle]){
                    indexRotated = indexStart;
                    break;
                }
            }else{
                indexEnd = indexMiddle-1;
                if (indexEnd >= 0 && nums[indexEnd] > nums[indexMiddle]){
                    indexRotated = indexMiddle;
                    break;
                }
            }
        }
        return Math.max(binarySearch(nums, 0, indexRotated-1, target), binarySearch(nums, indexRotated, nums.length-1, target));

    }

    public int binarySearch(int[] nums, int indexStart, int indexEnd, int target){
        int indexMiddle = 0;
        while (indexStart <= indexEnd){
            indexMiddle = (indexStart + indexEnd)/2;
            if (nums[indexMiddle] >target){
                indexEnd = indexMiddle-1;
            }else if (nums[indexMiddle] < target){
                indexStart = indexMiddle + 1;
            }else{
                return indexMiddle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        var x = new Q33SearchInRotatedSortedArray();
        System.out.println(x.search(new int[]{5,1, 3}, 5));
    }
}
