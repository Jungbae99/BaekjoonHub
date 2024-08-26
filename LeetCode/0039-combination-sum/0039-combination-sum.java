class Solution {
    // 이전 문제를 조합을 나열하되, 중복이 있으면 안된다. 그런데 이번엔 중복 허용이다.
    // target 이 넘어가는 시점에는 바로 return 하며 마치 백트래킹을 하듯이 구현하면 될 것 같다
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(answer, candidates, 0, target, 0, new ArrayList<>());

        return answer;
    }

    private void dfs(List<List<Integer>> answer, int[] candidates, int index, int target, int sum, ArrayList<Integer> cur) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            answer.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            cur.add(candidates[i]);
            dfs(answer, candidates, i, target, sum + candidates[i], cur);
            cur.remove(cur.size() - 1);
        }
    }

}