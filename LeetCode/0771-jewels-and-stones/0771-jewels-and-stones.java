class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        
        int count = 0;
        Map<Character, Integer> freqs = new HashMap<>();

        for (char c : stones.toCharArray()) {
            if (freqs.containsKey(c)) {
                freqs.put(c, freqs.get(c) + 1);
            } else {
                freqs.put(c, 1);
            }
        }

        for (char c : jewels.toCharArray()) {
            if (freqs.containsKey(c)) {
                count += freqs.get(c);
            }
        }

        return count;
    }
}