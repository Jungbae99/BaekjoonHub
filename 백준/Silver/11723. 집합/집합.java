import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        print(N, br, sb);
        System.out.println(sb);

    }

    private static void print(int n, BufferedReader br, StringBuilder sb) throws IOException {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            String calculate = arr[0];
            int num;
            switch (calculate) {
                case "add":
                    num = Integer.parseInt(arr[1]);
                    set.add(num);
                    break;
                case "remove":
                    num = Integer.parseInt(arr[1]);
                    set.remove(num);
                    break;
                case "check":
                    num = Integer.parseInt(arr[1]);
                    if (set.contains(num)) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "toggle":
                    num = Integer.parseInt(arr[1]);
                    if (set.contains(num)) {
                        set.remove(num);
                    } else {
                        set.add(num);
                    }
                    break;
                case "all":
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
    }


}