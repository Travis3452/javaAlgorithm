import java.util.Scanner;

public class javaBaekJoon10773 {
    static int N;
    static int [] stack;
    static int top = -1;

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        stack = new int [N];

        for(int i=0; i<N; i++) stack[i] = 0;

        for(int i=0; i<N; i++) {
            int temp = sc.nextInt();
            if(temp == 0) {
                pop();
            }
            else {
                push(temp);
            }
        }

        int sum = 0;
        for(int i=0; i<N; i++) {
            sum += stack[i];
        }

        System.out.println(sum);
    }
    public static void push(int num) {
        stack[++top] = num;
    }
    public static void pop() {
        stack[top--] = 0;
    }
}