import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
    
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeNode node = new TreeNode(Integer.parseInt(br.readLine()));

        while (true) {
            String input = br.readLine();
            if (input == null || "".equals(input)) {
                break;
            }
            // 노드를 이진탐색트리로 만들수있도록 메서드를 추가했습니다.
            node.insert(Integer.parseInt(input));
        }
        postOrder(node);
    }

    private static void postOrder(TreeNode node) {
        // 전,중,후 가 있고 후위순회는 [왼 -> 오 -> ROOT]
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }

        private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }


        public void insert(int n) {
            if (n < this.val) {
                if (this.left == null)
                    this.left = new TreeNode(n);
                else
                    this.left.insert(n);
            } else {
                if (this.right == null)
                    this.right = new TreeNode(n);
                else
                    this.right.insert(n);
            }
        }
    }
}