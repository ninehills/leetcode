// 递归比较复杂，DFS暴力搜索比较简单
class Solution {
    public Node connect(Node root) {
        bfs(root);
        return root;
    }

    void bfs(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node head = null;
            for(int i=0;i<size;i++){
                Node node = queue.poll();
                if (head != null) {
                    head.next = node;
                }
                head = node;
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }  
        }
        return;
    }
}