class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }

        return buildTree(1, n);
    }

    LinkedList<TreeNode> buildTree(int start, int end) {
        // 生成从start到end的所有二叉搜索树的根节点
        LinkedList<TreeNode> result = new LinkedList<TreeNode>();
        if (start > end){
            result.add(null);
            return result;
        }
        for(int i = start; i <= end; i++){
            // 循环所有root节点的可能
            // 左、右子树全部可能性
            LinkedList<TreeNode> leftTreeList = buildTree(start, i-1);
            LinkedList<TreeNode> rightTreeList = buildTree(i+1, end);
            for (TreeNode left: leftTreeList) {
                for (TreeNode right: rightTreeList) {
                    TreeNode root = new TreeNode(i);
                    if (left != null) {
                        root.left = left;
                    }
                    if (right != null) {
                        root.right = right;
                    }
                    result.add(root);
                }
            }
        }
        return result; 
    }
}