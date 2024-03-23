import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.*;


public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> index = new Stack<Integer>(); // 위치 저장

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());		//탑 개수

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= size; i++) {			//탑이 1번 부터 시작하므로
            int num = Integer.parseInt(st.nextToken());
            while (true) {
                if (!stack.empty()) {			//스택 안에 탑 있을 경우
                    int top = stack.peek();
                    if (top > num) {
                        System.out.print(index.peek() + " ");
                        stack.push(num);
                        index.push(i);
                        break;
                    } else { // num보다 작으면 어차피 num에 가려 필요없으므로 삭제
                        stack.pop();
                        index.pop();

                    }
                } else { // 스택 비어있을 경우
                    System.out.print("0 ");
                    stack.push(num);
                    index.push(i);
                    break;

                }

            }

        }
    }

}