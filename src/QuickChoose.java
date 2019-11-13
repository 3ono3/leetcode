import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QuickChoose {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }
    public static int findKthLargest(int[] nums, int k) {
        LinkedList<Integer> numsLikedList = new LinkedList<>();
        for (int num : nums) {
            numsLikedList.add(num);
        }
        int mink = nums.length - k +1;
        return quick(numsLikedList, 0, nums.length-1, mink-1);
    }
    public static int quick(LinkedList<Integer> nums, int left, int right, int minkIndex) {
        int sign = nums.get(left);
        int signIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums.get(i) < sign) {
                Integer numI = nums.remove(i);
                nums.add(0, numI);
                signIndex++;
            }
        }
        if (signIndex == minkIndex) {
            return sign;
        } else if (signIndex > minkIndex) {
            return quick(nums, left, signIndex-1, minkIndex);
        } else {
            return quick(nums, signIndex + 1, right, minkIndex);
        }
    }
}
