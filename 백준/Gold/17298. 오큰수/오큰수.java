

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        int arr[ ]= new int[n];
        int answer [] = new int[n];

        String[] input = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        for(int i=0; i<n; i++){
            while(!stack.empty() && arr[stack.peek()] < arr[i]){
                answer[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while(!stack.empty()){
            answer[stack.pop()] = -1;
        }

        for(int i=0; i<n; i++){
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}