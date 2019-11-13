package mostWater;

/**
 * @author GUOJINGYUAN487
 * @since 2018/11/26 0026
 */
public class Solution {

    public static void main(String[] str){
        int[] height = {8,10,14,0,13,10,9,9,11,11};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {

        if(height.length < 2) return 0;

        int maxHeight = 0, secHeight= 0;
        int maxIdx = 0,secIdx = 0;

        int leftIdx,rightIdx;

        for(int i = 0; i < height.length; i++){
            if(height[i] >= maxHeight){
                secIdx = maxIdx;
                secHeight = maxHeight;
                maxIdx = i;
                maxHeight = height[i];
            }else if(height[i] > secHeight){
                secIdx = i;
                secHeight = height[i];
            }
        }

        if(maxIdx > secIdx){
            leftIdx = secIdx;
            rightIdx = maxIdx;
        }else {
            leftIdx = maxIdx;
            rightIdx = secIdx;
        }

        for(int leftPoint = leftIdx - 1; leftPoint >= 0; leftPoint--){
            int tempWidth = rightIdx - leftPoint;
            int oldWidth = rightIdx - leftIdx;
            if( Math.min(height[leftPoint],height[rightIdx]) * tempWidth > Math.min(height[leftIdx],height[rightIdx]) * oldWidth){
                leftIdx = leftPoint;
            }
        }

        for(int rightPoint = rightIdx + 1; rightPoint < height.length; rightPoint++){
            int tempWidth = rightPoint - leftIdx;
            int oldWidth = rightIdx - leftIdx;
            if( Math.min(height[leftIdx],height[rightPoint]) * tempWidth > Math.min(height[leftIdx],height[rightIdx]) * oldWidth){
                rightIdx = rightPoint;
            }
        }

        int wid = rightIdx - leftIdx;
        int hei = height[leftIdx] > height[rightIdx] ? height[rightIdx] : height[leftIdx];

        System.out.println("leftIdx: " + leftIdx + ";   rightIdx: " + rightIdx);
        System.out.println("width: " + wid + ";   height: " + hei);
        return wid*hei;
    }

}
