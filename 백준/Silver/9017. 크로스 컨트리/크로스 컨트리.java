import java.io.*;
import java.util.*;

public class Main{

    private static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    //1. 6명 이상
    //2. 점수가 같으면 5번째 선수 비교
    //3. 6명 이하인 팀은 제외
    private static void solve() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int teamCount= 0;
        int[] arr = new int[N+1];
        int[] countParticipants = new int[202];
        int[] countCheck = new int[202];
        int[] score = new int[202];
        int[] fifth = new int[202];

		//1
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            countParticipants[arr[i]]++;
            teamCount = Math.max(teamCount, arr[i]);
        }
        
		//2
        int tmp = 0;
        for(int i=1; i<=N; i++){
            if(countParticipants[arr[i]] < 6) {
                tmp++; score[arr[i]] = Integer.MAX_VALUE; fifth[arr[i]] = Integer.MAX_VALUE;
            }
            else if(countCheck[arr[i]] < 4) {
                score[arr[i]] += i-tmp;
                countCheck[arr[i]]++;
            }
            else if(countCheck[arr[i]] == 4) {
                fifth[arr[i]] = i - tmp;
                countCheck[arr[i]]++;
            }
        }

		//3
        int bestTeam = 0, bestScore = Integer.MAX_VALUE;
        fifth[0] = Integer.MAX_VALUE;

        for(int i=1; i<=teamCount; i++){
            if(score[i] < bestScore){
                bestScore = score[i];
                bestTeam = i;
            }
            else if(score[i] == bestScore && fifth[i] < fifth[bestTeam]){
                bestTeam = i;
            }
        }
        System.out.println(bestTeam);
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        while(T-->0){
            solve();
        }
    }
}