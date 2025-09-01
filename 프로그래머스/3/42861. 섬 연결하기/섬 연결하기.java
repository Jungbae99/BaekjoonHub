import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        parents = new int[n];
        for(int i = 0; i< n; i++) parents[i] = i;
        
        for (int[] arr : costs) {
            int start = arr[0];
            int end = arr[1];
            int weight = arr[2];

            if(unionFind(start) == unionFind(end)) continue;
            answer += weight;
            
            parents[unionFind(end)] = unionFind(start);
        }

        return answer;
    }
    
    static int[] parents;
    
    public int unionFind(int node) {
        if(parents[node] == node) return parents[node];
        return unionFind(parents[node]);        
    } 
}