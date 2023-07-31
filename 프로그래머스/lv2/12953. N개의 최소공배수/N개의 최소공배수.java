import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        
        int result = arr[0];
        for(int i=0; i<arr.length; i++){
            result = lcm(result, arr[i]);
        }
        return result;
    }
    
    private static int lcm(int a, int b){
        return (a*b)/ gcd(a,b);
    }
    
    private static int gcd (int a, int b){
        while(b != 0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}