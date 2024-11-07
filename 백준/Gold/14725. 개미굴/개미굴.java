
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class TrieNode {

    Map<String, TrieNode> child;
    boolean isEnd;

    TrieNode() {
        this.child = new TreeMap<>();
        this.isEnd = false;
    }
}


public class Main {

    static TrieNode root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        root = new TrieNode();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            String[] foods = new String[K];
            for (int j = 0; j < K; j++) {
                foods[j] = st.nextToken();
            }
            insert(foods);
        }
        printStructure(root, 0);
    }

    private static void printStructure(TrieNode root, int depth) {
        for (String s : root.child.keySet()) {
            String prefix = "--".repeat(depth);
            System.out.println(prefix + s );
            printStructure(root.child.get(s), depth + 1);
        }
    }

    private static void insert(String[] foods) {
        TrieNode cur = root;

        for (String food : foods) {
            cur.child.putIfAbsent(food, new TrieNode());
            cur = cur.child.get(food);
        }
    }

}
