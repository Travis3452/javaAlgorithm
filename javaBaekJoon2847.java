import java.util.Scanner;

public class javaBaekJoon2847 {
    static int N;
    static int [] arr;
    static int min = Integer.MAX_VALUE;
    static int count = 0;
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int [N];

        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=N-1; i>=0; i--) {
            if(arr[i] >= min) {
                while(arr[i] >= min) {
                    count++;
                    arr[i] -= 1;
                }
                min = arr[i];
            }
            else min = arr[i];
        }

    System.out.println(count);
    }
}