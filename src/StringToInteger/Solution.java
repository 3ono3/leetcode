package StringToInteger;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Solution {
    public static void main(String[] str) {
        int result = myAtoi("  4193 with words");
        System.out.println(result);
    }

    public static int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() < 1) {
            return 0;
        }
        int radix = 10;
        int len = str.length();
        int i = 0;
        int limit = -Integer.MAX_VALUE;
        boolean isNegative = false;
        char firstChar = str.charAt(0);
        if (firstChar < '0') {
            if (firstChar != '-' && firstChar != '+') {
                return 0;
            }
            if (firstChar == '-') {
                limit = Integer.MIN_VALUE;
                isNegative = true;
            }
            i++;
        }
        int minum = limit/radix;
        int result = 0;
        while (i < len) {
            char ci = str.charAt(i);
            if (ci >= '0' && ci <= '9') {
                int digit = Character.digit(ci, radix);
                if (result < minum) {
                    result = limit;
                    break;
                }
                result *= radix;
                if (result < limit + digit) {
                    result = limit;
                    break;
                }
                result -= digit;

                i++;
            } else {
                break;
            }
        }
        return isNegative? result : -result;
    }
}
