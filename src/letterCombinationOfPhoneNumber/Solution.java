package letterCombinationOfPhoneNumber;

import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {

        String[][] phoneStr = {{},{},{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},
                {"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};

        List<String> result = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {
            int di = Integer.parseInt(String.valueOf(digits.charAt(i)));
            if (di > 9 || di < 2) {
                return result;
            }
            String[] dsa = phoneStr[di];
            if (result.size() < 1) {
                result.addAll(Arrays.asList(dsa));
                continue;
            }
            List<String> temp = new ArrayList<>(result);
            result.clear();
            for (String tempStr : temp) {
                for (String ds : dsa) {
                    String daa = tempStr + ds;
                    result.add(daa);
                }
            }
        }
        return result;
    }
}
