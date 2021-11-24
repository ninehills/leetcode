class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // 前序遍历整个树，但是放弃返回值，因为返回值只是root节点的单边最大路径和
        // 真正要的值是遍历过程中出现的最大路径和 maxSum
        oneSideMax(root);
        return maxSum;
    }

    // 遍历整个树，返回当前节点的单边最大路径和
    int oneSideMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左子节点的单边最大路径和，如果为负数，那么就设为0，因为可以选择最大路径不通过左子节点
        int leftMax = Math.max(0, oneSideMax(root.left));
        // 同上
        int rightMax = Math.max(0, oneSideMax(root.right));

        // 记录在遍历过程中出现过的最大路径和 = 左单边最大路径和 + 右单边最大路径和 + 自身
        maxSum = Math.max(leftMax + rightMax + root.val, maxSum);
        // 左或者右，返回单边最大路径和（必须通过左或右子节点，并加上该节点）
        return Math.max(leftMax, rightMax) + root.val;
    }
}