/*
需要利用完全二叉树的特性，左子树和右子树，至少有一个是满二叉树。

通过往左迭代到底和往右迭代到底，获得左右的高度，如果高度相同，就是满二叉树。
如果高度不同，那么就需要二次迭代，但是这次一个边就不用重新计算了。

这个结果比@labuladong的时间复杂度还要低
*/
class Solution {
    public int countNodes(TreeNode root) {
        return countNodesWithDepth(root, -1, -1);
    }
    public int countNodesWithDepth(TreeNode root, int leftDepth, int rightDepth) {
        if (root == null) {
            return 0;
        }
        if (leftDepth < 0) {
            // 如果传入的Depth < 0 ，证明需要重新找
            // 否则就是已经计算好，无需计算
            leftDepth = 0;
            TreeNode head = root;
            while (head != null) {
                head = head.left;
                leftDepth += 1;
            }
        }
        if (rightDepth < 0) {
            // 如果传入的Depth < 0 ，证明需要重新找
            // 否则就是已经计算好，无需计算
            rightDepth = 0;
            TreeNode head = root;
            while (head != null) {
                head = head.right;
                rightDepth += 1;
            }
        }
        if (leftDepth == rightDepth) {
            // 如果左右子树深度相等，那么就是一颗满二叉树
            // 节点数量为2^N - 1
            return (int)Math.pow(2, leftDepth) - 1;
        }
        // 分别计算左右，但是有一条边不用算了
        return 1 + countNodesWithDepth(root.left, leftDepth - 1, -1) + countNodesWithDepth(root.right, -1, rightDepth - 1);
    }
}