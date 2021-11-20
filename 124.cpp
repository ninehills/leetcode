// https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
class Solution {
public:
    int maxSum = INT_MIN;
    
    // 遍历整个树，返回当前节点的单边最大路径和
    int oneSideMax(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        // 左子节点的单边最大路径和，如果为负数，那么就设为0，因为可以选择最大路径不通过左子节点
        int leftMax = max(0, oneSideMax(root->left));
        // 同上
        int rightMax = max(0, oneSideMax(root->right));

        // 记录在遍历过程中出现过的最大路径和 = 左单边最大路径和 + 右单边最大路径和 + 自身
        maxSum = max(leftMax + rightMax + root->val, maxSum);
        // 左或者右，返回单边最大路径和（必须通过左或右子节点，并加上该节点）
        return max(leftMax, rightMax) + root->val;
    }

    int maxPathSum(TreeNode* root) {
        // 用通过当前节点的最大路径和 vs 遍历过程中出现的最大路径和进行比较，选择最大值
        oneSideMax(root);
        return maxSum;
    }
};
