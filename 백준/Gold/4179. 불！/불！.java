import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class FireNode {
    int x, y;

    public FireNode(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class PersonNode {
    int x, y;

    public PersonNode(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<FireNode> fireQueue = new LinkedList<>();
        Queue<PersonNode> personQueue = new LinkedList<>();

        char[][] arr = new char[n][m];
        int[][] fireDist = new int[n][m];
        int[][] personDist = new int[n][m];

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                arr[i][j] = c;
                fireDist[i][j] = -1;
                personDist[i][j] = -1;
                if (c == 'J') {
                    personQueue.add(new PersonNode(i, j));
                    personDist[i][j] = 0;
                }
                if (c == 'F') {
                    fireQueue.add(new FireNode(i, j));
                    fireDist[i][j] = 0;
                }
            }
        }


        while (!fireQueue.isEmpty()) {
            FireNode fireNode = fireQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nX = fireNode.x + dx[i];
                int nY = fireNode.y + dy[i];

                if (nX < 0 || nX >= n || nY < 0 || nY >= m) continue;
                if (fireDist[nX][nY] >= 0 || arr[nX][nY] == '#') continue;

                fireDist[nX][nY] = fireDist[fireNode.x][fireNode.y] + 1;
                fireQueue.add(new FireNode(nX, nY));
            }
        }

        while (!personQueue.isEmpty()) {
            PersonNode personNode = personQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nX = personNode.x + dx[i];
                int nY = personNode.y + dy[i];

                if (nX < 0 || nY < 0 || nX >= n || nY >= m) {
                    System.out.println(personDist[personNode.x][personNode.y] + 1);
                    return;
                }
                if (personDist[nX][nY] >= 0 || arr[nX][nY] == '#') continue;

                if (fireDist[nX][nY] != -1 && (fireDist[nX][nY] <= personDist[personNode.x][personNode.y] + 1)) continue;

                personDist[nX][nY] = personDist[personNode.x][personNode.y] + 1;
                personQueue.add(new PersonNode(nX, nY));
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}