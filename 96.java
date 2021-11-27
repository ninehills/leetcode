class Solution {
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        // 缓存已经计算出的结果
        int[][] countCache = new int[n+1][n+1]; 
        return countBST(1, n, countCache);

    }

    int countBST(int start, int end, int[][] countCache) {
        // 生成从start到end的所有二叉搜索树的可能数量
        int result = 0;
        if (start > end){
            return 1;
        }
        if (countCache[start][end] != 0){
            return countCache[start][end];
        }
        for(int i = start; i <= end; i++){
            // 循环所有root节点的可能
            // 左、右子树全部可能性
            int leftTreeCount = countBST(start, i-1, countCache);
            int rightTreeCount = countBST(i+1, end, countCache);
            result += leftTreeCount * rightTreeCount;
        }
        countCache[start][end] = result;
        return result;
    }
}