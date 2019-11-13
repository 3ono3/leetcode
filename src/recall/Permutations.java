package recall;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = permute(nums);
        for (List<Integer> every : result) {
            for (Integer i : every) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> sorted = new LinkedList<>();
        for (int num : nums) {
            sorted.add(num);
        }
        combination(result, 0, sorted, nums.length);
        return result;
    }

    /**
     *
     * @param result 结果集
     * @param sure 确认的长度
     * @param sorted 已排序的
     * @param length 数组长度
     */
    public static void combination(List<List<Integer>> result, int sure, List<Integer> sorted, int length) {
        if (sure == length) {
            result.add(new LinkedList<>(sorted));
            return;
        }
        for (int i = sure; i < length; i++) {
            Collections.swap(sorted, i, sure);
            combination(result, sure+1, sorted, length);
            Collections.swap(sorted, sure, i);
        }
    }
}
