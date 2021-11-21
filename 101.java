class Solution {
    // 进行前序和后序遍历，内容相同则为镜像
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else {
            return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }
    }
}