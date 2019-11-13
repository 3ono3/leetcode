package GrayCode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> result = new Solution().grayCode(0);
        result.stream().forEach(System.out::println);
    }
    public List<Integer> grayCode(int n) {
        List<Integer> list = new LinkedList<>();
        list.add(0);
        return codeSplice(list, 0, n);
    }
    public List<Integer> codeSplice(List<Integer> resultList, int start, int n) {
        if (start == n) {
            return resultList;
        }
        LinkedList<Integer> newResult = new LinkedList<>();
        boolean change = true;
        for (Integer i : resultList) {
            if(change) {
                newResult.add(i);
                newResult.add(i + (1 << start));
            } else {
                newResult.add(i + (1 << start));
                newResult.add(i);
            }
            change = !change;
        }
        List<Integer> result = codeSplice(newResult, start+1, n);
        return result;
    }
}
