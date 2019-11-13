package reverseInt;

/**
 * @author GUOJINGYUAN487
 * @since 2018/11/26 0026
 */
public class Solution {

    public static void main(String[] str){
        System.out.println(reverse(-14));
    }

    public static int reverse(int x) {

        int temp = x > 0 ? x : -x;

        int remain = temp % 10;
        int quotient = temp / 10;

        int result = 0;

        while(quotient > 0 || remain > 0){
            result = result*10 + remain;
            remain = quotient % 10;
            quotient = quotient / 10;
        }

        result = x > 0 ? result : -result;

        return result;
    }
}
