package DivideTwoIntegers;

public class Solution {
    public static void main(String[] args) {

    }
    public int divide(int dividend, int divisor) {
        boolean neavite;
        neavite = (dividend^divisor) < 0;
        int num = 0;
        while(dividend > divisor) {
            dividend  = dividend << 1;
            num++;
        }
        if (dividend == divisor) {
            num++;
        }
        return num;
    }
}
