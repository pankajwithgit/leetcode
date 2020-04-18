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
    private static final String SPLITTER = ",";
    private static final String NULL_VALUE = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        serialize(root, result);
        System.out.println(result.toString());
        return result.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder sb) {
        if(root == null) { 
            sb.append(NULL_VALUE).append(SPLITTER);
        } else {
            sb.append(root.val).append(SPLITTER);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(SPLITTER)));
        return buildTree(q);
    }
    
    private TreeNode buildTree(Queue<String> q) {
        String element = q.poll();
        if(element.equals(NULL_VALUE)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(element));
            node.left = buildTree(q);
            node.right = buildTree(q);
            return node;
        }
    }
    
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
