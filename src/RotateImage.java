public class RotateImage {

    public static void main(String[] args) {
        int[][] m1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        new RotateImage().rotate(m1);
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
                show(matrix);
                System.out.println("-");
            }
            System.out.println("--");
        }
        System.out.println("======");
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
                show(matrix);
                System.out.println("+");
            }
            System.out.println("++");
        }
    }
    public void show(int[][] matrix) {
        for (int[] l1 : matrix) {
            for (int l2 : l1) {
                System.out.print(l2+ "  ");
            }
            System.out.println();
        }
    }


}
