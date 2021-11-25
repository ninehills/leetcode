/* 使用dfs，然后当访问到叶子节点时，保存路径 */

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<Integer> path = new LinkedList<>();
        List<String> result = new ArrayList<String>();
        dfs(root, path, result);
        return result;
    }

    void dfs(TreeNode root, LinkedList<Integer> path, List<String> result) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        if (root.left == null && root.right == null) {
            // 叶子节点
            result.add(covertPath2String(path));
            path.removeLast();
            return;
        }
        dfs(root.left, path, result);
        dfs(root.right, path, result);
        path.removeLast();
        return;
    }

    String covertPath2String(LinkedList<Integer> path) {
        StringBuilder result = new StringBuilder();
        int i;
        for(i=0;i<path.size();i++) {
            result.append(path.get(i));
            if (i < path.size() - 1) {
                result.append("->");
            }
        }
        return result.toString();
    }
}