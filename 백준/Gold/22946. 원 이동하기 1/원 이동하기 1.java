
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static class Circle {
        int x, y, r, idx;
        ArrayList<Circle> children = new ArrayList<>();
        Circle parent = null;

        Circle(int x, int y, int r, int idx) {
            this.x = x;
            this.y = y;
            this.r = r;
            this.idx = idx;
        }

        // this가 c를 포함하는지
        boolean contains(Circle c) {
            long dx = this.x - c.x;
            long dy = this.y - c.y;
            long distSq = dx * dx + dy * dy;
            long rDiff = this.r - c.r;
            return rDiff > 0 && distSq < rDiff * rDiff;
        }
    }

    static int maxDepth = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Circle[] circles = new Circle[N + 1]; // 0번은 가상의 큰 원(좌표평면)
        circles[0] = new Circle(0, 0, Integer.MAX_VALUE, 0); // root

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            circles[i] = new Circle(x, y, r, i);
        }

        // 포함관계에 따라 부모 찾기
        for (int i = 1; i <= N; i++) {
            int parent = 0;
            int minParentR = Integer.MAX_VALUE;
            for (int j = 0; j <= N; j++) {
                if (i == j) continue;
                if (circles[j].contains(circles[i])) {
                    if (circles[j].r < minParentR) {
                        minParentR = circles[j].r;
                        parent = j;
                    }
                }
            }
            circles[i].parent = circles[parent];
            circles[parent].children.add(circles[i]);
        }

        // 트리의 지름 구하기
        maxDepth = 0;
        dfs(circles[0]);
        System.out.println(maxDepth);
    }

    // 리프에서 리프까지 가장 긴 경로(지름)
    static int dfs(Circle now) {
        int first = 0, second = 0;
        for (Circle child : now.children) {
            int d = dfs(child) + 1;
            if (d > first) {
                second = first;
                first = d;
            } else if (d > second) {
                second = d;
            }
        }
        // 두 리프를 잇는 경로는 first+second+1이지만, 문제에서 원만 세므로, 최대 방문 원의 개수는 first+second
        maxDepth = Math.max(maxDepth, first + second);
        return first;
    }
}