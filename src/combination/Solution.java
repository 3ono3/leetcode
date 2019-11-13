package combination;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationNum("AAB"));
    }

    public int combinationNum(String titles) {
        Character[] dict = titles.chars().mapToObj(c -> (char)c).toArray(Character[]::new); ;
        String write="";
        List<Character> d = Arrays.asList(dict);
        int result = print(write, Arrays.asList(dict), new HashSet<>());
        return result;
    }

    private int print(String write, List<Character> dict, HashSet<String> combination) {
        int count = 0;
        if (write.length() > 0 && !combination.contains(write)) {
            combination.add(write);
            count++;
        }
        for (int i = 0; i < dict.size(); i++) {
            LinkedList<Character> tdict = new LinkedList<>(dict);
            Character t = tdict.remove(i);
            count += print(write+t, tdict, combination);
        }
        return count;
    }

    private int print2(String write, List<Character> dict, HashSet<String> combination) {
        int count = 0;
        for (int i = 0; i < dict.size(); i++) {
            LinkedList<Character> tdict = new LinkedList<>(dict);
            Character t = tdict.remove(i);
            write = write+t;
            if (write.length() > 0 && !combination.contains(write)) {
                combination.add(write);
                count++;
            }
            count += print2(write+t, tdict, combination);
        }
        return count;
    }
}
