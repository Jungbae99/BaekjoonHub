public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backTracking(nums, new ArrayList<>(), answer);
        return answer;
    }

    private void backTracking(int[] nums, List<Integer> current, List<List<Integer>> answer) {
        // 만약 깊이우선탐색을 하면서, 가장 깊은 depth 로 왔다면 정답으로 추가해준다
        if (current.size() == nums.length) {
            answer.add(new ArrayList<>(current));
            System.out.println(current.stream().collect(Collectors.toList()));
        }

        for (int num : nums) {
            if (current.contains(num)) continue;
            current.add(num);
            backTracking(nums, current, answer);
            current.remove(current.size() - 1);
        }
    }
}
