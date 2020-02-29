package LeetCode.question1to50;

public class Q11ContainerWithMostWater {
    /**
     * 先让容器宽度最大，在逐渐减少宽度，增加高度，确定最大容量
     * @param height 容器高度的列表
     * @return 容器最大容量
     */
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int height_temp = height[i] < height[j] ? height[i] : height[j];
        int capacity = (j - i) * height_temp;
        while (i < j){
            if (height[i] <= height_temp){
                i++;
            }else if (height[j] <= height_temp){
                j --;
            }else{
                height_temp = height[i] < height[j] ? height[i] : height[j];
                capacity = capacity > height_temp * (j - i) ? capacity : height_temp * (j - i);
            }

        }
        return capacity;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        var b = new Q11ContainerWithMostWater();
        System.out.println(b.maxArea(a));
    }
}
