import java.util.HashMap;

class Solution {
    public int solution(String s) {
        HashMap<String, String> map = new HashMap<>();
        map.put("zero", String.valueOf(0));map.put("one", String.valueOf(1));
        map.put("two", String.valueOf(2));map.put("three", String.valueOf(3));
        map.put("four", String.valueOf(4));map.put("five", String.valueOf(5));
        map.put("six", String.valueOf(6));map.put("seven", String.valueOf(7));
        map.put("eight", String.valueOf(8));map.put("nine", String.valueOf(9));
        
        for(String x : map.keySet()){
            if(s.contains(x)) s = s.replaceAll(x, map.get(x));
        }
        
        return Integer.parseInt(s);
    }
}