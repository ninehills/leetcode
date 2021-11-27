class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTWithRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }
    boolean isValidBSTWithRange(TreeNode root, int min, int max){
        // 判断root是否为二叉搜索树，并且所有节点需要在min -> max 闭范围
        if (root == null) {
            return true;
        }
        if (root.val < min || root.val > max) {
            return false;
        }

        // 如果root恰好为Integer.MIN_VALUE或Integer.MAX_VALUE，那么就需要特殊处理
        if (root.val == Integer.MIN_VALUE && root.left != null) {
            // 如果root已经为最小值，且还有左树，那一定不满足条件
            return false;
        }
        if (root.val == Integer.MAX_VALUE && root.right != null) {
            // 如果root已经为最大值，且还有右树，那一定不满足条件
            return false;
        }

        // 判断左右子树
        if(!isValidBSTWithRange(root.left, min, root.val - 1)) {
            return false;
        }
        if(!isValidBSTWithRange(root.right, root.val + 1, max)) {
            return false;
        }
        return true;
    }
}