import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        long answer = 0;

        for (int i = 0; i < n; i++) {

            int height = sc.nextInt();

            while (!stack.isEmpty()) {

                if (stack.peek() <= height) {
                    stack.pop();
                } else break;
            }
            answer += stack.size();
            stack.push(height);
        }
        System.out.println(answer);

    }

}