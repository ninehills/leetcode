class Solution {
    int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        int rootHeight = getHeight(root, 0);
        return Math.min(rootHeight, minDepth);
    }

    int getHeight(TreeNode root, int layer) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left, layer + 1);
        int rightHeight = getHeight(root.right, layer + 1);
        if (leftHeight == 0 && rightHeight == 0) {
            // 叶子节点
            minDepth = Math.min(minDepth, layer + 1);
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}