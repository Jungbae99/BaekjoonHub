import java.util.*;

class Main{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        Stack<Integer> stack = new Stack<>();
        
        int k = sc.nextInt();
        
        for(int i=0; i<k ; i++){
            int number = sc.nextInt();
            
            if(number == 0){
                stack.pop();
            } else {
                stack.push(number);
            }
        }
        int sum = 0;
        
        for (Integer o : stack) {
            sum += o;
        }
        System.out.print(sum);        
    }
    
    
}