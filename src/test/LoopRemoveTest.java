package test;

import java.util.ArrayList;
import java.util.List;

public class LoopRemoveTest {
    public static void main (String[] str) {
        List<String> list = new ArrayList<String>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");}};
        for(String s : list) {
            if ("H".equals(s)) {
                list.remove(s);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ": " + list.get(i));
        }
    }
}
