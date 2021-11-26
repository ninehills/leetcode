public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 使用前序遍历的方式进行持久化，以,为分隔符，null就是null
        LinkedList<Integer> result = new LinkedList<>();

        serializeAsList(root, result);
        return listToString(result);
    }

    void serializeAsList(TreeNode root, LinkedList<Integer> result) {
        if (root == null){
            result.add(null);
            return;
        }
        result.add(root.val);
        serializeAsList(root.left, result);
        serializeAsList(root.right, result);
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<Integer> dataAsList = stringToList(data);
        return deserializeAsList(dataAsList);

    }

    TreeNode deserializeAsList(LinkedList<Integer> data) {
        Integer val = data.pollFirst();
        if (val == null) {
            return null;
        }
        TreeNode root = new TreeNode(val);
        root.left = deserializeAsList(data);
        root.right = deserializeAsList(data);
        return root;
    }

    String listToString(LinkedList<Integer> in) {
        StringBuilder result = new StringBuilder();
        int i;
        for (i=0; i < in.size() - 1; i++){
            result.append(in.get(i));
            result.append(',');
        }
        result.append(in.get(i));
        return result.toString();
    }

    LinkedList<Integer> stringToList(String in) {
        LinkedList<Integer> result = new LinkedList<>();
        String[] inSplit = in.split(",");
        for (String i : inSplit) {
            if (i.equals("null")) {
                result.add(null);
            } else {
                result.add(Integer.parseInt(i));
            }
        }
        return result;
    }
}
