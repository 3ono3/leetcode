import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        level(result, 0, root);
        return result;
    }

    public void level(List<List<Integer>> result, int level, TreeNode node) {
        if (node == null) {
            return;
        }
        while (level > result.size()-1) {
            result.add(new ArrayList<>());
        }
        List<Integer> levelList = result.get(level);
        levelList.add(node.val);
        level(result, level+1, node.left);
        level(result, level+1, node.right);
    }
}
