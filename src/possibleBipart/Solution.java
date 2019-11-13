package possibleBipart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GUOJINGYUAN487
 * @since 2018/11/29 0029
 */
public class Solution {
    List<Integer>[] nodeDisList;
    Map<Integer,Integer> color;
    public boolean possibleBipartition(int N, int[][] dislikes) {
        nodeDisList = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            nodeDisList[i] = new ArrayList<>();
        }
        for(int[] nodeDis : dislikes){
            nodeDisList[nodeDis[0]].add(nodeDis[1]);
            nodeDisList[nodeDis[1]].add(nodeDis[0]);
        }

        color = new HashMap<>();
        for(int i = 1; i <= N; i++){
            if(!color.containsKey(i) && !dis(i,0)){
                return false;
            }
        }
        return true;

    }

    public boolean dis(Integer node,Integer nodeColor){
        if(color.containsKey(node)){
            return color.get(node).equals(nodeColor);
        }
        color.put(node,nodeColor);
        for(Integer nodeDis : nodeDisList[node]){
            if(!dis(nodeDis,nodeColor ^ 1)){
                return false;
            }
        }
        return true;
    }
}
