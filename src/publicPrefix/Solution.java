package publicPrefix;

public class Solution {
    public static void main(String[] str) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuffer result = new StringBuffer("");
        if (strs != null && strs.length > 0) {
            String firstStr = strs[0];
            char[] value = firstStr.toCharArray();
            for (int i = 0; i < value.length; i++) {
                char c = value[i];
                boolean appendCan = true;
                for (int j = 1; j < strs.length && appendCan; j++) {
                    String jStr = strs[j];
                    if (jStr.length() > i) {
                        char jc = jStr.charAt(i);
                        if (!(c == jc)) {
                            appendCan = false;
                        }
                    } else {
                        appendCan = false;
                        break;
                    }
                }
                if (appendCan) {
                    result.append(c);
                } else {
                    break;
                }
            }
        }
        return result.toString();
    }
}
