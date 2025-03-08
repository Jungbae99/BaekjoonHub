class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
                List<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            if (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.add(i);

            if (i >= k - 1) {
                result.add(nums[dq.peek()]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}