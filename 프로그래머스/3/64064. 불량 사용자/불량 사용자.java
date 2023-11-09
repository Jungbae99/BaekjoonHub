import java.util.*;

class Solution {
    static Set<String> set;
    static StringBuilder sb;
    static boolean[] visited;

    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();
        sb = new StringBuilder();
        visited = new boolean[user_id.length];
        int answer = 0;

        dfs(0, banned_id, user_id, "");

        answer = set.size();
        for (String s : set) {
            System.out.println("s = " + s);
        }
        return answer;
    }

    private void dfs(int depth, String[] banned_id, String[] user_id, String result) {

        if (depth == banned_id.length) {

            String[] split = result.split(" ");
            Arrays.sort(split);

            set.add(Arrays.toString(split));
            return;
        }

        for (int i = 0; i < user_id.length; i++) {

            if (visited[i] || !check(banned_id[depth], user_id[i])) continue;

            visited[i] = true;
            dfs(depth + 1, banned_id, user_id, result + " " + i);
            visited[i] = false;
        }

    }

    private boolean check(String ban, String user) {
        if (ban.length() != user.length()) {
            return false;
        }
        for (int i = 0; i < ban.length(); i++) {
            if (ban.charAt(i) == '*') continue;
            if (ban.charAt(i) != user.charAt(i)) {
                return false;
            }
        }
        return true;
    }


}