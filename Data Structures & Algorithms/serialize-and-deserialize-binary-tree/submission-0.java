/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        inorderTraversal(root, str);
        return str.toString();
    }

    public void inorderTraversal(TreeNode node, StringBuilder str) {
        if (node == null) {
            str.append("null#");
            return;
        }
        str.append(node.val).append("#");
        inorderTraversal(node.left, str);
        inorderTraversal(node.right, str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;
        String[] nodes = data.split("#");
        return getTree(nodes, new int[] { 0 });
    }

    public TreeNode getTree(String[] nodes, int[] idx) {
        if (idx[0] >= nodes.length || nodes[idx[0]].equals("null")) {
            idx[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[idx[0]]));
        idx[0]++;
        node.left = getTree(nodes, idx);
        node.right = getTree(nodes, idx);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));