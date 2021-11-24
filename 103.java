class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        travelTree(root, 0, result);
        return result;
    }

    void travelTree(TreeNode root, int layer, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        if (layer > result.size() - 1) {
            // 每层使用 LinkedList，让头尾插入的时间复杂度都为 O(1)
            List<Integer> layerList = new LinkedList<Integer>();
            result.add(layerList);
        }
        if (layer % 2 == 0) {
            result.get(layer).add(root.val);
        } else {
            result.get(layer).add(0, root.val);
        }
        travelTree(root.left, layer + 1, result);
        travelTree(root.right, layer + 1, result);
    }
}