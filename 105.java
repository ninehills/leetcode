/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // inorder 的反向HashMap，通过value找到offset
        HashMap<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for(int i=0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTreeWithArgs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, inMap);
    }

    // 辅助方法，增加了preoder和inorder的头尾指针
    TreeNode buildTreeWithArgs(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, HashMap<Integer, Integer> inMap) {
        // 边界条件，如果preoder或inorder遍历完成，则返回空指针
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // 整体逻辑：根据先序遍历得到根节点，然后在中序遍历中找到根节点的位置，它的左边就是左子树的节点，右边就是右子树的节点。
        // 根节点的值为 preorder 中 preStart 指针指向的值
        int preRoot = preorder[preStart];
        int inRoot = inMap.get(preRoot);
        // numsLeft 为左树的节点数量
        int numsLeft = inRoot - inStart;
        TreeNode root = new TreeNode(preRoot);
        // 左节点递归
        root.left = buildTreeWithArgs(preorder, inorder, preStart + 1, preStart + numsLeft, inStart, inRoot - 1, inMap);
        // 右节点递归
        root.right = buildTreeWithArgs(preorder, inorder, preStart + numsLeft + 1, preEnd, inRoot + 1, inEnd, inMap);
        return root;
    }
}
