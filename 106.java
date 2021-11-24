// 直接套模式，后序遍历反向loop，则解决问题
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // inorder 的反向HashMap，通过value找到offset
        HashMap<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for(int i=0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTreeWithArgs(postorder, inorder, postorder.length - 1, 0, 0, inorder.length - 1, inMap);
    }
    // 辅助方法，增加了postoder和inorder的头尾指针
    TreeNode buildTreeWithArgs(int[] postorder, int[] inorder, int postStart, int postEnd, int inStart, int inEnd, HashMap<Integer, Integer> inMap) {
        // 边界条件，如果postorder或inorder遍历完成，则返回空指针
        if (postStart < postEnd || inStart > inEnd) {
            return null;
        }
        int postRoot = postorder[postStart];
        int inRoot = inMap.get(postRoot);
        int numsRight = inEnd - inRoot;
        TreeNode root = new TreeNode(postRoot);
        root.left = buildTreeWithArgs(postorder, inorder, postStart - numsRight - 1, postEnd, inStart, inRoot - 1, inMap);
        root.right = buildTreeWithArgs(postorder, inorder, postStart - 1, postEnd, inRoot + 1, inEnd, inMap);
        return root;
    }
}