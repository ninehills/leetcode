class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        connectNode(root.left, root.right);
        return root;
    }

    void connectNode(Node node1, Node node2) {
        if (node1 == null || node2 == null ) {
            return;
        }

        node1.next = node2;
        connectNode(node1.left, node1.right);
        connectNode(node2.left, node2.right);
        connectNode(node1.right, node2.left);
    }
}