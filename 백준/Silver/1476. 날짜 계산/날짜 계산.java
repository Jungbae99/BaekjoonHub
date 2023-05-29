import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[] = new int[3];

        for (int i = 0; i < 3; i++) {
            arr[i] = in.nextInt();
        }
        int a=1, b=1, c=1, cnt = 1;
        while(!(a==arr[0] && b==arr[1] && c==arr[2])){
            if(a==15) a = 1;
            else a++;
            if(b==28) b = 1;
            else b++;
            if(c==19) c = 1;
            else c++;
            cnt ++;
        }
        System.out.println(cnt);


    }
}