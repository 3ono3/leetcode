package NextPermutation;

public class Solution {
    public static void main(String[] args) {
        int [] a = {1,3,2};
        new Solution().solution(a);
    }
    public void solution(int[] nums) {
        boolean opt = false;
        for (int i = nums.length-1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                opt = true;
                int temp = nums[i-1];
                for (int j = nums.length-1; j > i-1; j--) {
                    if (nums[j] > temp) {
                        nums[i-1] = nums[j];
                        nums[j] = temp;
                        temp = nums[i];
                        for(int x = i; x < (nums.length-i)/2 + i; x++) {
                            int tm = nums[x];
                            int q = nums.length-x+i-1;
                            nums[x] = nums[q];
                            nums[q] = tm;

                        }
//                        nums[nums.length - 1] = temp;
                        break;
                    }
                }
                break;
            }
        }
        if (!opt) {
            for (int p = 0; p < nums.length/2; p++) {
                int q = nums.length -1 - p;
                int temp = nums[p];
                nums[p] = nums[q];
                nums[q] = temp;
            }
        }

        for (int n : nums) {
            System.out.println(n);
        }
    }
}
