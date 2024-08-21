import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] numbers = new String[n];
            for (int j = 0; j < n; j++) {
                numbers[j] = br.readLine();
            }
            Arrays.sort(numbers); 
            System.out.println(isConsistentPhoneList(n, numbers));
        }
    }

    private static String isConsistentPhoneList(int n, String[] numbers) {
        for (int i = 0; i < n - 1; i++) {
            String first = numbers[i];
            String second = numbers[i + 1];

            if (second.startsWith(first)) {
                return "NO";
            }
        }
        return "YES";
    }
}
