class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        travelTree(root, 0, result);
        return result;
    }

    void travelTree(TreeNode root, int layer, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        if (layer > result.size() - 1) {
            List<Integer> layerList = new ArrayList<Integer>();
            result.add(layerList);
        }
        result.get(layer).add(root.val);
        travelTree(root.left, layer + 1, result);
        travelTree(root.right, layer + 1, result);
    }
}