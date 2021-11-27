class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTreeWithBorder(nums, 0, nums.length - 1);

    }
    public TreeNode constructMaximumBinaryTreeWithBorder(int[] nums, int start, int end) {
        if (end < start || start < 0 || end >= nums.length) {
            return null;
        }
        int maxIndex = findMaxElementIndex(nums, start, end);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructMaximumBinaryTreeWithBorder(nums, start, maxIndex - 1);
        root.right = constructMaximumBinaryTreeWithBorder(nums, maxIndex + 1, end);
        return root;
    }

    int findMaxElementIndex(int[] nums, int start, int end) {
        // 寻找数组中制定区间最大元素的下标，假设所有参数合法且数组不为空
        int result = start;
        for(int i=start+1; i<=end; i++) {
            if (nums[i] > nums[result]) {
                result = i;
            }
        }
        return result;
    }
}
