## Tips

- 尽可能使用 Java 语言，并尽量规避语言特性
- 按照分类进行，先把某种类型吃透再进行下一种类型
- 先只局限于前300题中的免费题目

## 二叉树

### 二叉树遍历

遍历基础：
- DFS（深度优先）
    - 实现方式：
        - 递归
        - 迭代
    - 遍历方式：
        - 前序
        - 中序
        - 后序
- BFS（广度优先），依赖Stack数据类型。

递归的要点：
- root节点的动作
- 构造可以递归的方法

| 题目 | 难度 | 备注 | 错题记录 |
| --- | --- | --- | --- |
| [94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/) | | |
| [100. 相同的树](https://leetcode-cn.com/problems/same-tree/) | | |
| [101. 对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/) | | |
| [102. 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/) | | |
| [103. 二叉树的锯齿形层序遍历](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/) | | |
| [104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/) | | |
| [105. 从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) | | |
| [106. 从中序与后序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/) | | |
| [107. 二叉树的层序遍历 II](https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/) | | |
| [110. 平衡二叉树](https://leetcode-cn.com/problems/balanced-binary-tree/) | | |
| [111. 二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/) | | |
| [112. 路径总和](https://leetcode-cn.com/problems/path-sum/) | | |
| [113. 路径总和 II](https://leetcode-cn.com/problems/path-sum-ii/) | | |
| [114. 二叉树展开为链表](https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/) | | |
| [116. 填充每个节点的下一个右侧节点指针](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/) | | |
| [117. 填充每个节点的下一个右侧节点指针 II](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/) | | |
| [124. 二叉树中的最大路径和](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/) | | |
| [129. 求根节点到叶节点数字之和](https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/) | | |
| [144. 二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/) | | 依赖Stack数据类型（或者List）实现DFS前序遍历二叉树 |
| [145. 二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/) | | TODO：需要用迭代实现前中后遍历 |
| [199. 二叉树的右视图](https://leetcode-cn.com/problems/binary-tree-right-side-view/) | 中等 | |
| [222. 完全二叉树的节点个数](https://leetcode-cn.com/problems/count-complete-tree-nodes/) | 中等 | 解法超过了例子 | |
| [226. 翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/) | 中等 | | | 
| [236. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/) | 中等 | 完成存储父节点方法，TODO 需要递归方案 | 
| [257. 二叉树的所有路径](https://leetcode-cn.com/problems/binary-tree-paths/)
| [297. 二叉树的序列化与反序列化 ](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/)

### 二叉搜索树