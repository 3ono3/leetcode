public class Queen {
    static int n = 4;
    static int[] queen = new int[n+1];

    public static void main(String[] args) {
        nQueen(1);
    }
    public static void show() {
        int i;
        System.out.print("(");
        for (i = 1; i <= n; i++) {
            System.out.print(queen[i] + ",");
        }
        System.out.println(")");
    }
    public static int place(int j) {
        for (int i = 1; i < j; i++) {
            if (queen[j] == queen[i] || Math.abs(queen[j]-queen[i]) == (j-i)) {
                return 0;
            }
        }
        return 1;
    }

    public static void nQueen(int j) {
        for (int i =1; i <= n; i++) {
            queen[j] = i;
            if ((place(j)==1) && j<=n) {
                if (j == n) {
                    show();
                } else {
                    nQueen(j+1);
                }
            }
        }
    }
}
