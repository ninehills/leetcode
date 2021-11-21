class Solution {
    List<Integer> inorder = new ArrayList<Integer>();
    List<Integer> emptyList = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if ( root == null ) {
            return emptyList;
        }
        inorderTraversal(root.left);
        inorder.add(root.val);
        inorderTraversal(root.right);
        return inorder;
    }
}