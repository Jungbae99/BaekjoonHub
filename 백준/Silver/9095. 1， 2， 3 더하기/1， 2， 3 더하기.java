import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T =  Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            int d[] = new int[n+1];

            if(n==0){
                bw.write(String.valueOf(1)); bw.newLine();

            }
            else if(n==1) {
                bw.write(String.valueOf(1));bw.newLine();

            }
            else if(n==2) {
                bw.write(String.valueOf(2));bw.newLine();

            }
            else{
                d[0] = 1;
                d[1] = 1;
                d[2] = 2;
                int tmp = 0;
                for (int j = 3; j <= n; j++) {
                    d[j] = d[j-1] + d[j-2] + d[j-3];
                    tmp = d[j];
                }
                bw.write(String.valueOf(tmp));
                bw.newLine();
            }
        }
        bw.flush();
    }
}