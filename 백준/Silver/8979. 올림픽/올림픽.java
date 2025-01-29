
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] medals = new int[N][4];
        int targetGold = 0, targetSilver = 0, targetBronze = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            if (country == K) {
                targetGold = gold;
                targetSilver = silver;
                targetBronze = bronze;
            }
            medals[i] = new int[]{country, gold, silver, bronze};
        }

        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (medals[i][0] == K) continue;

            if (medals[i][1] > targetGold ||
                    (medals[i][1] == targetGold && medals[i][2] > targetSilver) ||
                    (medals[i][1] == targetGold && medals[i][2] == targetSilver && medals[i][3] > targetBronze)) {
                rank++;
            }
        }

        System.out.println(rank);
    }
}