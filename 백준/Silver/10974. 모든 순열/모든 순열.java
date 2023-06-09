import java.util.Scanner;

public class Main {
    static int n;
    static int arr[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        do{
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }while(nextpermulation(arr));

    }

    public static boolean nextpermulation(int arr[]) {
        int i = n-1;
        while (i > 0 && arr[i] < arr[i - 1]) i -= 1;
        if(i==0) return false;

        int j = n-1;
        while(arr[i-1] > arr[j]) j-= 1;

        swap(i-1, j);
        j = n - 1;
        while (j > i) {
            swap(j,i);
            j--; i++;
        }
        return true;
    }

    public static void swap(int j, int i) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

