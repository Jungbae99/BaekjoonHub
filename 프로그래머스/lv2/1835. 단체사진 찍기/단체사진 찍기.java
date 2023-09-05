class Solution {
    static boolean[] visited;
    static char[] friends;
    static String [] dt;
    static int answer;
    public int solution(int n, String[] data) {
        friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        dt = data;
        answer = 0;
        visited = new boolean[8];
        dfs("", 0);
        return answer;
    }
    private static void dfs(String line, int depth) {
        if (depth == 8) {
            if(check(line)) answer++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(line + friends[i] , depth+1);
                visited[i] = false;
            }
        }


    }

    private static boolean check(String line) {
        for(String cond : dt)
        {
            int diff = (Math.abs(line.indexOf(cond.charAt(0)) - line.indexOf(cond.charAt(2))))-1;
            char sign = cond.charAt(3);
            int val = cond.charAt(4)-'0';

            if(sign == '=')
            {
                if(diff != val) return false;
            }
            else if(sign == '>')
            {
                if(diff <= val) return false;
            }
            else
            {
                if(diff >= val) return false;
            }
        }
        return true;
    }
}