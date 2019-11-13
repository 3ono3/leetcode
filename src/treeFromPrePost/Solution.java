package treeFromPrePost;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

/**
 * @author GUOJINGYUAN487
 * @since 2018/11/28 0028
 */
public class Solution {
    public static void main(String[] str){
        int[] pre = {1,2,4,5,3,6,7};
        int[] post = {4,5,2,6,7,3,1};
        constructFromPrePost(pre,post);
    }
    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        int N = pre.length;
        if(N <= 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        if(N == 1) return root;
        int L = 0;
        for(int i = 0; i < N; i++){
            if(post[i] == pre[1]){
                L = i;
                break;
            }
        }

        root.left = constructFromPrePost(Arrays.copyOfRange(pre,1,2+L),
                Arrays.copyOfRange(post,0,L+1));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre,L+2,N),
                Arrays.copyOfRange(post,L+1,N-1));
        return root;
    }
}
