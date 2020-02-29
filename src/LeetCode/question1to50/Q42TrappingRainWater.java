package LeetCode.question1to50;

public class Q42TrappingRainWater {
    /**
     *
     * @param height 高度列表
     * @return 雨水承受量
     */
    public int trap(int[] height) {
        int indexStart = 0, indexEnd=height.length-1;
        int result = 0;
        int heightTemp1 = 0, heightTemp2 = 0;
        while (indexStart <= indexEnd){
            heightTemp1 = Math.min(height[indexStart], height[indexEnd]);
            result += (indexEnd - indexStart + 1) * (heightTemp1 - heightTemp2);
            heightTemp2 = heightTemp1;
            while (indexStart <= indexEnd && height[indexStart] <= heightTemp1){
                indexStart += 1;
            }
            while (indexStart <= indexEnd && height[indexEnd] <= heightTemp1){
                indexEnd -= 1;
            }
        }
        int heightSum = 0;
        for(int height1: height){
            heightSum += height1;
        }
        return result- heightSum;
    }

    public static void main(String[] args) {
        var x = new Q42TrappingRainWater();
        System.out.println(x.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
