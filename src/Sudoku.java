import java.util.HashMap;
import java.util.Map;

public class Sudoku {
    public boolean isValidSudoku(char[][] board) {

        Map<Integer, Integer>[] rows = new HashMap[9];
        Map<Integer, Integer>[] columns = new HashMap[9];
        Map<Integer, Integer>[] boxs = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxs[i] = new HashMap<>();
        }

        for (int dep = 0; dep < 9; dep++) {
            HashMap<Integer,Integer> rowH = (HashMap<Integer, Integer>) rows[dep];
            for (int wid = 0; wid < 9; wid++) {
                char s = board[dep][wid];

            }
        }
        return false;
    }
}
