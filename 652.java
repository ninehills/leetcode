class Solution {
    HashMap<String, Integer> subtrees = new HashMap<String, Integer>();

    LinkedList<TreeNode> result = new LinkedList<TreeNode>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return result;

    }

    String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String leftStr = serialize(root.left);
        String rightStr = serialize(root.right);
        // 此处注意也要用后序遍历的顺序，左右中
        String treeStr = leftStr + ',' + rightStr + ',' + root.val;
        int count = subtrees.getOrDefault(treeStr, 0);
        if (count == 1) {
            // 如果第一次重复
            result.add(root);
        }
        subtrees.put(treeStr, count+1);
        return treeStr;
    }
}