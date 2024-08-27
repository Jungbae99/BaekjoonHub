class Solution {
public List<List<Integer>> subsets(int[] nums) {
        // 주어진 예시 1,2,4 로 그림을 그려보면,,, 그냥 1, 12, 124, 14, 2, 24, 4 이런식으로
        // index 를 계속 증가시키면 중복되지않는다. 책에서는 자기자신보다 큰 값이 자식노드인 트리형태가 된다고 표현함...

        List<List<Integer>> answer = new ArrayList<>();
        dfs(answer, new ArrayList<>(), nums, 0);


        return answer;
    }

    private void dfs(List<List<Integer>> answer, ArrayList<Integer> cur, int[] nums, int index) {
        // 단 모든 결과를 저장해야하므로 맨 처음 빈 배열부터, 모든 탐색경로를 저장한다
        answer.add(new ArrayList<>(cur));
        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(answer, cur, nums, i + 1);
            cur.remove(cur.size() - 1);
        }

    }
} 