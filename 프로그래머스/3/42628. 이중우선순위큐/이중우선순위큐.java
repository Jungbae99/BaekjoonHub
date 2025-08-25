import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minQ = new PriorityQueue<>();

        for (String op : operations) {
            String[] arr = op.split(" ");
            String command = arr[0];
            String val = arr[1];

            if ("I".equals(command)) {
                Integer v = Integer.valueOf(val);
                maxQ.add(v);
                minQ.add(v);
            } else {
                if (!maxQ.isEmpty()) {
                    if ("-1".equals(val)) {
                        maxQ.remove(minQ.poll());
                    } else {
                        minQ.remove(maxQ.poll());
                    }
                }
            }
        }

        if (maxQ.isEmpty()) {
            return new int[]{0, 0};
        }
        return new int[]{maxQ.peek(), minQ.peek()};
    }
}