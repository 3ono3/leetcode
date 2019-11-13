package NQueenMy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public  static void main(String [] args) {
        List<List<String>> resultList = new Solution().solution(4);
        resultList.forEach(item -> {
            item.forEach(System.out::println);
            System.out.println("|");
        });
    }
    public List<List<String>> solution(int n) {
        List<List<String>> resultList = new LinkedList<>();
        //下标为行，值为列
        int[] result = new int[n];

        dfn(resultList, result, 0, n);

        return  resultList;
    }

    public void dfn(List<List<String>> resultList, int[] result, int row, int n) {
        if (row == n) {
            List<String> resultMember = new LinkedList<>();
            for (int r = 0; r < n; r++) {
                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < n; c++) {
                    sb.append(result[r] == c ? "Q" : ".");
                }
                resultMember.add(sb.toString());
            }
            resultList.add(resultMember);
            return;
        }
        for (int column = 0; column < n; column++) {
            result[row] = column;
            boolean isOk = true;
            for (int r = 0; r < row; r++) {
                if (result[r] == column || (Math.abs(column - result[r])== (row - r))) {
                    isOk = false;
                    break;
                }
            }
            if(isOk) {
                dfn(resultList, result, row+1, n);
            }
        }
    }
}
