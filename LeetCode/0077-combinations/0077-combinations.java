class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // 숫자 n에 대하여 1,2,3,4,5...n 을 배열에 넣고 배열의 k 번째 숫자에 도달했을때 List<Integer> 를 add 하는 방식으로 dfs 를 해보자
        List<List<Integer>> answer = new ArrayList<>();
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = n;
        }

        dfs(answer, new ArrayList<>(), 1, k, n);
        return answer;
    }

    private void dfs(List<List<Integer>> answer, ArrayList<Integer> cur, int start, int k, int n) {
        if (cur.size() == k) {
            answer.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i <= n; i++) {
            cur.add(i);
            dfs(answer, cur, i + 1, k, n);
            cur.remove(cur.size() - 1);
        }
    }

}