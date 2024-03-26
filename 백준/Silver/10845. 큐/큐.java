import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int number=Integer.parseInt(br.readLine());

        Queue<Integer> queue=new LinkedList<>();

        for (int i=0;i<number;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            String commend=st.nextToken();
            
            if (commend.equals("push")){
                int pushNumber=Integer.parseInt(st.nextToken());
                queue.add(pushNumber);
            } else if (commend.equals("front")) {
                if (queue.isEmpty()){
                    System.out.println(-1);
                } else {
                    System.out.println(queue.peek());
                }
            } else if (commend.equals("back")) {
                if (queue.size()==0){
                    System.out.println(-1);
                } else {
                    int lastNumber=((LinkedList<Integer>) queue).getLast();
                    System.out.println(lastNumber); 
                }
            } else if (commend.equals("size")) {
                System.out.println(queue.size());
            } else if (commend.equals("empty")) {
                if (queue.isEmpty()){
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (commend.equals("pop")) {
                if (queue.isEmpty()){
                    System.out.println(-1);
                } else {
                    System.out.println(queue.poll());
                }
            }
        }
    }
}