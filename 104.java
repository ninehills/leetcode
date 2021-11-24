class Solution {
    int depth = 0;
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        travelTree(root, 0);
        return depth + 1;
    }

    void travelTree(TreeNode root, int layer) {
        if (root == null) {
            return;
        }
        if (layer > depth) {
            depth = layer;
        }
        travelTree(root.left, layer + 1);
        travelTree(root.right, layer + 1);
    }
}