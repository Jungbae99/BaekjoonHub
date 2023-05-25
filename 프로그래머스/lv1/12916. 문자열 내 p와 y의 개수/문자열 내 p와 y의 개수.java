class Solution {
    boolean solution(String s) {
        int p=0;
        int y=0;
        String[]arr = s.split("");
        for(int i=0; i<arr.length ; i++){
            if(arr[i].equals("p") || arr[i].equals("P")) p++;
            if(arr[i].equals("y") || arr[i].equals("Y")) y++;
        }
        if(p == 0 && y == 0) return true;
        if(p==y) return true;
        else return false;
    
    }
}