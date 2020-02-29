package LeetCode.question1to50;

public class Q45JumpGameTwo {

    /**
     *
     * @param nums 非负整数数组
     * @return 达数组的最后一个位置最少的跳跃次数
     */
    public int jump(int[] nums) {
        int result = 0, indexPosition = 0;
        while (indexPosition < nums.length-1){
            int indexPositionNext = 0, indexPositionNextNext = 0;
            for (int i = indexPosition; i <= nums[indexPosition] + indexPosition; i++){
                if (i >= nums.length-1){
                    indexPositionNext = i;
                    break;
                }
                if (i + nums[i] > indexPositionNextNext){
                    indexPositionNext = i;
                    indexPositionNextNext = i + nums[i];
                }
            }
            indexPosition = indexPositionNext;
            result += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        var x = new Q45JumpGameTwo();
        System.out.println(x.jump(new int[]{2,3,1,1,4}));
    }

}
