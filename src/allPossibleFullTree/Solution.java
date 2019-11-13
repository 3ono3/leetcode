package allPossibleFullTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GUOJINGYUAN487
 * @since 2018/11/28 0028
 */
public class Solution {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> result = new ArrayList<>();

        if(N <= 0){
            return null;
        }
        if( N % 2 == 0 ){
            return null;
        }

        TreeNode ancestor = new TreeNode(0); //始祖
        if(N < 2){
            result.add(ancestor);
            return result;
        }
        TreeNode targetor = ancestor;

        int n = N;
        for(;n > 0;){
            targetor.left = new TreeNode(0);
            targetor.right = new TreeNode(0);
            targetor = targetor.left;
            n = n-2;
        }
        result.add(ancestor);

        return null;
    }
}
