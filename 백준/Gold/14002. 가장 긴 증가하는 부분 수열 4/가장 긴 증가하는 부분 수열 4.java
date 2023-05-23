import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] A = new int[N+1];
        int [] d = new int[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 1;
        for (int i = 1; i <= N; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if(A[j] < A[i] && d[i] < d[j]+1){
                    d[i] = d[j] + 1;
                }
            }
            answer = Math.max(d[i], answer);
        }

        Stack<Integer> stack = new Stack<>();
        int value = answer;
        for(int i = N; i>=1; i--){
            if(value == d[i]){
                stack.push(A[i]);
                value --;
            }
        }
        while(!stack.empty()){
            sb.append(stack.pop()+" ");
        }



        System.out.println(answer);
        System.out.println(sb);
    }
}