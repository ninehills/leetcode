/* 
解法1: 做层序遍历，选每层最右侧的节点。

解法2: 递归遍历，巧妙的找出每层第一个遍历的节点
*/

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        dfsRight(root, 0, result);
        return result;
    }

    void dfsRight(TreeNode root, int layer, List<Integer> result) {
        if (root == null) {
            return;
        }
        if(layer == result.size()) {
            // 当层数 - 1等于result的长度时，代表第一次遍历到这一层
            result.add(root.val);
        }
        // 使用先序遍历的方法，但是先右子树后左子树
        dfsRight(root.right, layer + 1, result);
        dfsRight(root.left, layer + 1, result);
        return;
    }
}