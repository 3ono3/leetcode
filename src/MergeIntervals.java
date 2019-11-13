import java.util.ArrayList;
import java.util.Collections;

public class MergeIntervals {
    public static void main(String[] args) {
//        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals = {{1,4},{0,0}};
        int[][] result = merge(intervals);
        for (int[] temp : result) {
            System.out.print("{");
            for (int t : temp) {
                System.out.print(t + ",");
            }
            System.out.print("}");
        }
    }
    public static int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();
        int paramLength = intervals.length;
        for (int i = 0; i < paramLength; i ++) {
            for (int j = 0; j < paramLength - i - 1; j ++) {
                if (intervals[j][0] > intervals[j+1][0]) {
                    int[] temp = intervals[j+1];
                    intervals[j+1] = intervals[j];
                    intervals[j] = temp;
                }
            }
        }
        System.out.println(intervals);
        /*for (int i = 0; i < paramLength; ) {
            int[] ri = intervals[i];
            int j = i + 1;
            for (j = i + 1; j < paramLength; j++) {
                int[] intervalJ = intervals[j];
                int jLeft = intervalJ[0];
                int jRight = intervalJ[1];

                if (jLeft <= ri[1]) {
                    ri[0] = jLeft < ri[0] ? jLeft : ri[0];
                    ri[1] = jRight > ri[1] ? jRight : ri[1];
                }

                if (jRight > ri[1]) {
                    break;
                }
            }
            i = j;
            result.add(ri);
        }*/
        for (int i = 0; i < paramLength; i++) {
            if (result.size() == 0 || result.get(result.size()-1)[1] < intervals[i][0]) {
                result.add(intervals[i]);
            }else {
                int[] re = result.get(result.size()-1);
                if (intervals[i][1] > re[1]) {
                    re[1] = intervals[i][1];
                    result.set(result.size()-1, re);
                }
            }
        }
        int[][] ra = new int[result.size()][2];
        for (int x = 0; x < result.size(); x++) {
            ra[x] = result.get(x);
        }
        return ra;
    }
}
