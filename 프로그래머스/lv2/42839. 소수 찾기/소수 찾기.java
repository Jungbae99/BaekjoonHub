import java.util.*;
class Solution {
    static ArrayList<Integer> arr;
    static boolean[] check;

    public int solution(String numbers) {
        int answer = 0;
        arr = new ArrayList<>();
        check = new boolean[numbers.length()];

        // 가능한 모든 숫자 조합을 생성합니다.
        for (int i = 1; i <= numbers.length(); i++) {
            dfs(numbers, "", i);
        }

        // 생성된 숫자 조합 중 소수를 찾습니다.
        for (int num : arr) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    private void dfs(String numbers, String temp, int n) {
        
         if (temp.length() > n) {
            return;
        }

        
        if (temp.length() == n) {
            int num = Integer.parseInt(temp);
            if (!arr.contains(num)) {
                arr.add(num);
            }
        }
        for (int i = 0; i < numbers.length(); i++) {
            if (!check[i]) {
                check[i] = true;
                temp += numbers.charAt(i);
                dfs(numbers, temp, n);
                check[i] = false;
                temp = temp.substring(0, temp.length() - 1);
            }
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

