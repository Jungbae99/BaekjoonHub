
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (dfs(root) == -1) {
            return false;
        }
        return true;
    }
    
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = dfs(node.left);
        int right = dfs(node.right);

        int abs = Math.abs(left - right); // 높이차이가 2이상이면 계속 -1 return
        
        if (left == -1 || right == -1 || abs > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}