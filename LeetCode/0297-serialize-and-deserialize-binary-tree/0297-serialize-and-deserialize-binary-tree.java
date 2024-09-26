
public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        sb.append(root.val + ", ");
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();

            if (poll.left != null) {
                queue.add(poll.left);
                sb.append(poll.left.val + ", ");
            } else {
                sb.append("null, ");
            }
            if (poll.right != null) {
                sb.append(poll.right.val + ", ");
                queue.add(poll.right);
            } else {
                sb.append("null, ");
            }
        }
        return sb.toString();
    }


    public TreeNode deserialize(String data) {
                if (data == null || data.isEmpty()) {
            return null;
        }
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0].trim()));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < values.length; i++) {
            TreeNode parent = queue.poll();
            if (parent != null) {
                String leftVal = values[i].trim();
                if (!"null".equals(leftVal)) {
                    parent.left = new TreeNode(Integer.parseInt(leftVal));
                    queue.offer(parent.left);
                }
                i++;
                String rightVal = values[i].trim();
                if (!"null".equals(rightVal)) {
                    parent.right = new TreeNode(Integer.parseInt(rightVal));
                    queue.offer(parent.right);
                }
            }
        }
        return root;
    }


}
