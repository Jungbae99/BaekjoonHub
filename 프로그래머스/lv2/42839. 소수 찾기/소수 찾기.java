import java.util.*;
class Solution {
    HashSet<Integer> hs = new HashSet<>();

    public int solution(String numbers) {
        rec("", numbers);

        int cnt = 0;
        Iterator<Integer> ite = hs.iterator();
        while (ite.hasNext()) {
            int number = ite.next();
            if(primeNumber(number)) {
                cnt++;
            }
        }
        return cnt;
    }

    public void rec (String temp, String n) {
        if(!temp.equals("")) {
            hs.add(Integer.parseInt(temp));
        }

        for (int i = 0; i < n.length(); i++) {
            rec(temp + n.charAt(i), n.substring(0, i) + n.substring(i + 1));
        }
    }
    static boolean primeNumber(int n) {
        if(n == 0 || n == 1) return false;
        for (int i = 2; i < n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

}