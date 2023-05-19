
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String a = br.readLine();
        String[] numbers= a.split(" ");
        int [] A = new int[numbers.length];
        int [] d = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            A[i] = Integer.parseInt(numbers[i]);
        }

        for (int i = 0; i < N; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if(A[j] < A[i] && d[i] < d[j]+1){
                    d[i] = d[j] + 1;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(d[i], answer);
        }
        System.out.println(answer);
    }
}