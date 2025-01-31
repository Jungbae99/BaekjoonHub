import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while (true) {
            s = br.readLine();
            if (s.equals("end")) break;
            boolean mFlag = false;
            boolean eoFlag = true;
            boolean jmFlag = true;
            int mCnt = 0;
            int jCnt = 0;


            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                    mFlag = true;
                    mCnt++;
                    jCnt = 0;
                    if (mCnt >= 3) {
                        jmFlag = false;
                        break;
                    }
                } else {
                    jCnt++;
                    mCnt = 0;
                    if (jCnt >= 3) {
                        jmFlag = false;
                        break;
                    }
                }

                if (i >= 1) {
                    if (s.charAt(i) != 'e' && s.charAt(i) != 'o') {
                        if (s.charAt(i) == s.charAt(i - 1)) eoFlag = false;
                    }
                }
            }

            if (jmFlag && eoFlag && mFlag) {
                System.out.println("<" + s + "> is acceptable.");
            } else {
                System.out.println("<" + s + "> is not acceptable.");
            }
        }
    }
}