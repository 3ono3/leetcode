package ThreeSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] strs) {
        int[] nums = {1,-1,0,0,0,0};
        List<List<Integer>> result = threeSum(nums);
        for (List<Integer> eleList : result) {
            for (Integer ele : eleList) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Map<Integer, List<Integer>> eleHad = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            List<Integer> hadEle = eleHad.get(ele);
            if (hadEle == null) {
                hadEle = new ArrayList<>();
            }
            for (int j = i+1; j < nums.length-1; j++) {
                int jEle = nums[j];
                if (hadEle.contains(jEle)) {
                    continue;
                }
                int sub = 0 - (ele + jEle);
                for (int x = j + 1; x < nums.length; x++) {
                    int xEle = nums[x];
                    List<Integer> hadXEle = eleHad.get(ele);
                    if (hadXEle == null) {
                        hadXEle = new ArrayList<>();
                    }
                    if (hadXEle.contains(xEle)) {
                        continue;
                    }
                    if (xEle == sub) {
                        List<Integer> group = new ArrayList<>();
                        group.add(ele);
                        group.add(jEle);
                        group.add(xEle);
                        resultList.add(group);

                        hadEle.add(jEle);
                        hadEle.add(xEle);
                        eleHad.put(ele, hadEle);

                        List<Integer> jEleList = eleHad.get(jEle);
                        if (jEleList == null) {
                            jEleList = new ArrayList<>();
                        }
                        jEleList.add(ele);
                        jEleList.add(xEle);
                        eleHad.put(jEle, jEleList);

                        List<Integer> xEleList = eleHad.get(xEle);
                        if (xEleList == null) {
                            xEleList = new ArrayList<>();
                        }
                        xEleList.add(ele);
                        xEleList.add(jEle);
                        eleHad.put(xEle, xEleList);

                    }
                }
            }
        }
        return resultList;
    }

}
