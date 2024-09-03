import java.util.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
        static Map<String, PriorityQueue<String>> map;
    static LinkedList<String> linkedList;

    public String[] solution(String[][] tickets) {
        map = new HashMap<>();
                linkedList = new LinkedList<>();

        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }

        dfs("ICN");

        return linkedList.toArray(new String[0]);
    }

    private void dfs(String start) {
        PriorityQueue<String> strings = map.get(start);
        while (strings != null && !strings.isEmpty()) {
          dfs(strings.poll());  
        } 
        linkedList.addFirst(start);
    }
    
}






