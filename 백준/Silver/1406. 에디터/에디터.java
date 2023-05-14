import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        StringBuilder output = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        for(char x : a.toCharArray()) stack1.push(x);
        int num = Integer.parseInt(br.readLine());

        for(int i=0; i<num; i++){
            char[] c = br.readLine().toCharArray();
            if(c[0]=='L') {
                if(!stack1.empty()) stack2.push(stack1.pop());
            }
            else if(c[0]=='P') stack1.push(c[2]);
            else if (c[0]=='D'){
                    if(!stack2.empty()) stack1.push(stack2.pop());
                }
            else if(c[0]=='B') {
                if(!stack1.empty()) stack1.pop();
            }
        }

        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        while(!stack2.empty()){
            output.append(stack2.pop());
        }

        System.out.println(output);
    }
}