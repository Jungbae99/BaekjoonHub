class Solution {

    static int max;

    public int longestUnivaluePath(TreeNode root) {
        max = 0;
        dfs(root);
        return this.max;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);

        if (node.left != null && node.left.val == node.val) {
            left++;
        } else {
            left = 0;
        }

        if (node.right != null && node.right.val == node.val) {
            right++;
        } else {
            right = 0;
        }

        this.max = Math.max(this.max, right + left);

        return Math.max(left, right);
    }
}