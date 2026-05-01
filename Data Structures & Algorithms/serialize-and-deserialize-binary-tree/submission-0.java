/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    List<String> result = new ArrayList<>();
    int current = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        result = new ArrayList<>();
        dfs(root);
        return String.join(",", result);
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            result.add("N");
            return;
        }
        result.add(String.valueOf(node.val));
        dfs(node.left);
        dfs(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        current = 0;
        String[] chars = data.split(",");
        return dfsDes(chars);
    }

    private TreeNode dfsDes(String[] chars) {
        if (Objects.equals(chars[current], "N")) {
            current += 1;
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(chars[current]));
        current += 1;
        node.left = dfsDes(chars);
        node.right = dfsDes(chars);
        return node;
    }
}
