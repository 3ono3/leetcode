package NQueen;

import java.util.LinkedList;
import java.util.List;

public class FuncSolution {

    /**
     * 斜着的函数没起作用
     * @param args
     */
    public  static void main(String [] args) {
        List<List<String>> resultList = new FuncSolution().funSolution(4);
        resultList.forEach(item -> {
            item.forEach(System.out::println);
            System.out.println("|");
        });
    }
    public List<List<String>> funSolution(int n) {
        List<List<String>> resultList = new LinkedList<>();
        boolean[] upwardDiag = new boolean[2*n];
        boolean[] downWardDiag = new boolean[2*n];
        boolean[] columnDiag = new boolean[n];
        dfn(resultList, new LinkedList<>(), upwardDiag, downWardDiag, columnDiag, n);
        return resultList;
    }
    public void dfn(List<List<String>> resultList,LinkedList<Integer> list, boolean[] upwardDiag, boolean[] downWardDiag, boolean[] columnDiag, int n) {
        if (list.size() == n) {
            List<String> resultMember = new LinkedList<>();
            for (int r = 0; r < n; r++) {
                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < n; c++) {
                    sb.append(list.get(r).equals(c) ? "Q" : ".");
                }
                resultMember.add(sb.toString());
            }
            resultList.add(resultMember);
        }

        for (int i = 0; i < n; i++) {
            if (upwardDiag[i] || downWardDiag[i] || columnDiag[i]) {
                continue;
            }
            list.add(i);
            upwardDiag[list.size() - 1 - i + n] = true;
            downWardDiag[list.size() - 1 + i] = true;
            columnDiag[i] = true;
            dfn(resultList, list, upwardDiag, downWardDiag, columnDiag, n);
            upwardDiag[list.size() - 1 - i + n] = false;
            downWardDiag[list.size() - 1 + i] = false;
            columnDiag[i] = false;
            list.removeLast();

        }
    }
}
