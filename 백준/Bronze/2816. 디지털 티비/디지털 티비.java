
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> arr = fillArr(N, br);
        answer = new ArrayList<>();

        updateKBS1(arr, "KBS1");
        updateKBS1(arr, "KBS2");

        for (int i = 0; i < answer.size() - 1; i++) {
            System.out.print(answer.get(i));
        }

    }

    private static void updateKBS1(List<String> arr, String target) {
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (target.equals(arr.get(i))) {
                arr.remove(target);
                ((LinkedList<String>) arr).addFirst(target);
                count = i;
            }
        }

        fillAnswerByString(count);

    }

    private static void fillAnswerByString(int count) {
        for (int i = 0; i < count; i++) {
            answer.add(1);
        }
        for (int i = 0; i < count; i++) {
            answer.add(4);
        }
    }


    private static List<String> fillArr(int n, BufferedReader br) throws IOException {
        List<String> arr = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            arr.add(br.readLine());
        }
        return arr;
    }
}
