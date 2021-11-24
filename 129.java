class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root, path);
        return sum;
    }

    void dfs(TreeNode root, LinkedList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            sum += covertPath2Num(path);
            path.removeLast();
            return;
        }
        dfs(root.left, path);
        dfs(root.right, path);
        path.removeLast();
        return;
    }

    int covertPath2Num(LinkedList<Integer> path) {
        ArrayList<Integer> array = new ArrayList<Integer>(path);
        int result = 0;
        for (int j=array.size()-1, i=1; j>=0; j--, i*=10) {
            result += array.get(j) * i;
        }
        return result;
    }
}