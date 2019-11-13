package spiralMatrix;

/**
 * @author GUOJINGYUAN487
 * @since 2018/11/27 0027
 */
public class Solution {
    public static void main(String[] str){
        int[][] res = spiralMatrixIII(5,6,1,4);
        for(int i = 0; i < res.length; i++){
            System.out.println("[" + res[i][0] + "," + res[i][1] + "]");
        }
    }

    public static int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] result = new int[R*C][2];
        result[0][0] = r0;
        result[0][1] = c0;

        int step = 1;
        //1向右，2向下，3向左，4向上
        int direction = 1;
        int rn = 1;

        while(true){

            switch (direction){
                case 1 :
                    for(int i = step; i > 0; i--){
                        if(++c0 < C && c0 >=0 && r0 >= 0 && r0 < R){
                            result[rn][0] = r0;
                            result[rn][1] = c0;
                            rn++;
                        }
                    }
                    direction = 2;
                    break;
                case 2 :
                    for(int i = step; i > 0; i--){
                        if(++r0 < R && r0 >= 0 && c0 < C && c0 >=0){
                            result[rn][0] = r0;
                            result[rn][1] = c0;
                            rn++;
                        }
                    }
                    step++;
                    direction = 3;
                    break;
                case 3 :
                    for(int i = step; i > 0; i--){
                        if(--c0 >= 0 && c0 < C && r0 >= 0 && r0 < R){
                            result[rn][0] = r0;
                            result[rn][1] = c0;
                            rn++;
                        }
                    }
                    direction = 4;
                    break;
                case 4 :
                    for(int i = step; i > 0; i--){
                        if(--r0 >= 0 && r0 < R && c0 >= 0 && c0 < C){
                            result[rn][0] = r0;
                            result[rn][1] = c0;
                            rn++;
                        }
                    }
                    direction = 1;
                    step++;
                    break;
            }
            if(rn >= R*C) break;
        }
        return result;
    }
}
