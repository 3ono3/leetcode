package ThreeSumClosest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] strs) {
        int nums[] = {-1,2,1,-4};
        int traget = 1;
        int result = new Solution().threeSumClosest(nums, traget);
        System.out.println(result);
    }
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        if (nums == null || nums.length < 1) {
            return result;
        }
        int length = nums.length;
        if (length < 4) {
            for (int num : nums) {
                result += num;
            }
            return result;
        }
        Arrays.sort(nums);
        outer:
        for(int i = 0; i < length-2; i++) {
            int ni = nums[i];
            int p = i + 1;
            int q = length - 1;
            int sub = target - ni;
            int pq = nums[p] + nums[q];
            while (q > p) {
                int adpq = nums[p] + nums[q];
                int subsub = sub - adpq;
                if (subsub == 0) {
                    result = adpq + ni;
                    break outer;
                }else {
                    if (subsub > 0 && q > p+1) {
                        int adpqnew = nums[++p] + nums[q];
                        if (Math.abs(sub - pq) < Math.abs(sub - adpqnew)) {
                            break ;
                        }

                        pq = adpqnew;

                        /*int subnew = sub - adpqnew;
                        if(Math.abs(subsub) < Math.abs(subnew)) {
                            if (Math.abs(sub - adpq) < Math.abs(target - result)) {
                                result = adpq + ni;
                            }
                            p--;
                            break;
                        }*/
                    }else if(q-1 > p){
                        int adpqnew = nums[p] + nums[--q];
                        if (Math.abs(sub - pq) < Math.abs(sub - adpqnew)) {
                            break ;
                        }

                        pq = adpqnew;

                        /*int subnew = sub - adpqnew;
                        if(Math.abs(subsub) < Math.abs(subnew)) {
                            if (Math.abs(sub - adpq) < Math.abs(target - result)) {
                                result = adpq + ni;
                            }
                            q++;
                            break;
                        }*/
                    }else {
                        break ;
                    }
                }
            }

            int resultTemp = ni + nums[p] + nums[q];
            if (Math.abs(target - resultTemp) < Math.abs(target - result)) {
                result = resultTemp;
            }
        }
        return result;
    }
}