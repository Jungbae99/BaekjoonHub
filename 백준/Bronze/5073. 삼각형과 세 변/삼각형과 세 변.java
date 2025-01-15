import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        while (true) {
            Integer[] arr = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            if(!checkZero(arr)) break;

            Arrays.sort(arr, Collections.reverseOrder()); // 내림차순 정렬

            int first = arr[0];
            int second = arr[1];
            int third = arr[2];

            if (first >= second + third) {
                System.out.println("Invalid");
            } else if (first == second && first == third) {
                System.out.println("Equilateral");
            } else if (first != second && second != third && first != third) {
                System.out.println("Scalene");
            } else {
                System.out.println("Isosceles");
            }
        }
    }

    private static boolean checkZero(Integer[] arr) {
        int first = arr[0];
        int second = arr[1];
        int third = arr[2];

        if (first == 0 && second == 0 && third == 0) {
            return false;
        }
        return true;
    }

}
