class Solution {
    public int lengthOfLongestSubstring(String s) {
        int pre = 0;
        int index = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        while(index < s.length()) {
            char cur = s.charAt(index);
            if(!set.contains(cur)) {
                set.add(cur);
                index++;
                max = Math.max(max, set.size());
            }
            else {
                set.remove(s.charAt(pre));
                pre++;
            }
        }
        return max;
    }
}