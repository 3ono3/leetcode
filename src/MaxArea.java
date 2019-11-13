public class MaxArea {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
        System.out.println(largestRectangleAreaFenzhi(heights));
    }
    public static int largestRectangleArea(int[] heights) {
        //柱子的数量
        int num = heights.length;
        int maxArea = 0;
        for (int i = 0; i < num; i++) {
            int width = 0;
            int height = heights[i];
            for (int j = i; j < num; j++) {
                width++;
                //最小值
                height = Math.min(height, heights[j]);
                maxArea = Math.max(height * width, maxArea);
            }
        }
        return maxArea;
    }

    public static int largestRectangleAreaFenzhi(int[] heights) {
        int maxArea = largestArea(heights, 0, heights.length-1, 0);
        return maxArea;
    }
    public static int largestArea(int[] heights, int left, int right, int maxArea) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            maxArea = Math.max(heights[left], maxArea);
            return maxArea;
        }
        int minIndex = left;
        int minValue = heights[left];
        int i;
        for (i = left + 1; i <= right; i++) {
            if (heights[i] < minValue) {
                minValue = heights[i];
                minIndex = i;
            }
        }
        maxArea = Math.max(minValue*(right - left + 1), maxArea);

        return Math.max(maxArea, Math.max(largestArea(heights, left, minIndex-1, maxArea),largestArea(heights, minIndex+1, right, maxArea)));
    }
}
