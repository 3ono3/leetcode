package IntegerToRoman;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
    */
    private static final Map<Integer, String> ROMAN_MAP = new HashMap<>(7);
    private static final char NINE_CHAR = '9';
    private static final char FOUR_CHAR = '4';
    static {
        ROMAN_MAP.put(1, "I");
        ROMAN_MAP.put(5, "V");
        ROMAN_MAP.put(10, "X");
        ROMAN_MAP.put(50, "L");
        ROMAN_MAP.put(100, "C");
        ROMAN_MAP.put(500, "D");
        ROMAN_MAP.put(1000, "M");
    }

    public static void main(String[] str) {
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        int sn = num / 1000;
        num = num % 1000;
        loopAppend(sb, sn, "M");
        if (num >= 100) {
            num = remainderAppend(sb, num, 100);
        }
        if (num >= 10) {
            num = remainderAppend(sb, num, 10);
        }
        if (num > 0) {
            remainderAppend(sb, num, 1);
        }

        return sb.toString();
    }

    public static int remainderAppend (StringBuilder sb, int remainder, int romanInt) {
        if (sPre(remainder, NINE_CHAR)) {
            sb.append(ROMAN_MAP.get(romanInt));
            sb.append(ROMAN_MAP.get(romanInt*10));
        } else if (sPre(remainder, FOUR_CHAR)) {
            sb.append(ROMAN_MAP.get(romanInt));
            sb.append(ROMAN_MAP.get(romanInt*5));
        } else {
            int sn = remainder / romanInt;
            if (sn >= 5) {
                sb.append(ROMAN_MAP.get(romanInt*5));
                loopAppend(sb, sn-5, ROMAN_MAP.get(romanInt));
            } else {
                loopAppend(sb, sn, ROMAN_MAP.get(romanInt));
            }
        }
        return remainder % romanInt;
    }
    public static StringBuilder loopAppend (StringBuilder sb, int num, String sa) {
        for (int i = 0; i < num; i++) {
            sb.append(sa);
        }
        return sb;
    }

    public static boolean sPre (int num, char prefix) {
        String sNum = Integer.toString(num);
        return  prefix==sNum.charAt(0);
    }
}
