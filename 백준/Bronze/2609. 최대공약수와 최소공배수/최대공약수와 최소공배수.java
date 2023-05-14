import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String arr[] = str.split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);

        int intGcd = GCD.gcd(a,b);
        int intLmc = (a*b)/intGcd;

        bw.write(Integer.toString(intGcd));
        bw.newLine();
        bw.write(Integer.toString(intLmc));
        bw.newLine();
        
        bw.flush();  // 버퍼 비우기
        bw.close();  // BufferedWriter 닫기
        br.close();  // BufferedReader 닫기
    }
}
class GCD{
    public static int gcd(int a, int b){
        if(b==0) return a;
        else{
           return gcd(b, a%b);
        }
    }
}