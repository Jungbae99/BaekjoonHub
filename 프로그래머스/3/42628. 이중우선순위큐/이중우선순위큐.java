import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> min = new PriorityQueue<>();
        Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < operations.length; i++) {
            String execute = operations[i].split(" ")[0];
            String value = operations[i].split(" ")[1];

            if (execute.equals("I")) {
                min.add(Integer.valueOf(value));
                max.add(Integer.valueOf(value));
            }

            if (execute.equals("D")) {
                if (!max.isEmpty()) {
                    if (value.equals("-1")) {
                        max.remove(min.poll());
                    } else {
                        min.remove(max.poll());
                    }
                }
            }
        }


        if (max.isEmpty()) {
            return new int[]{0, 0};
        }
        return new int[]{max.poll(), min.poll()};
    }
}