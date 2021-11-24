class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<Integer> path = new LinkedList<Integer>();
        travelTree(root, targetSum, path, res);
        return res;
    }

    void travelTree(TreeNode root, int targetSum, LinkedList<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                // find it!
                LinkedList<Integer> copyPath = new LinkedList<Integer>(path);
                res.add(copyPath);
            }
            path.removeLast();
            return;
        }
        travelTree(root.left, targetSum - root.val, path, res);
        travelTree(root.right, targetSum - root.val, path, res);
        path.removeLast();
        return;
    }
}