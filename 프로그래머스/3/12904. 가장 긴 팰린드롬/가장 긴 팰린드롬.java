class Solution {
    public int solution(String s) {
        char[] arr = s.toCharArray();

        for (int i = s.length(); i > 0; i--) {
            for (int j = 0; i + j <= s.length(); j++) {
                if(isPalindrome(s, j, i + j - 1, arr)) return i;
            }
        }

        return 0;
    }

    private boolean isPalindrome(String str, int start, int end, char[] arr) {

        while (start <= end) {
            if (arr[start++] != arr[end--]) {
                return false;
            }
        }

    return true;
    
    }
}