import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int num = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[1000001];
        for (int i = 2; i <= 1000000; i++) {
            if(!prime[i]){
                for(int j=i+i; j<1000000; j+=i){
                    prime[j] = true;
                }}}

        while(num-- > 0 ){
            int tmp = Integer.parseInt(br.readLine());
            int answer = 0;
            for (int i = 2; i <= tmp / 2; i++) {
                if(!prime[i] && !prime[tmp-i]) answer++;
            }
            sb.append(answer).append(System.lineSeparator());
        }

        System.out.println(sb);

    }
}
