class Solution {
    
   private int best = Integer.MAX_VALUE; // 최소 단계 저장

    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfs(begin, target, words, visited, 0);

        return best == Integer.MAX_VALUE ? 0 : best;
    }

    private void dfs(String begin, String target, String[] words, boolean[] visited, int depth) {
        if (depth >= best) return;

        if (begin.equals(target)) {
            best = depth;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && diffOne(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, visited, depth + 1);
                visited[i] = false;
            }
        }
    }

    private boolean diffOne(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}