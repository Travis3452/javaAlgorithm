import java.util.Scanner;

public class javaBaekJoon11501 {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for(int i=0; i<N; i++) {
            int size = sc.nextInt();
            long gain = 0;
            int [] arr = new int [size];

            for(int j=0; j<size; j++) {
                arr[j] = sc.nextInt();
            }

            int max = 0;

            for(int j=size-1; j>=0; j--){
                if(max < arr[j]) max = arr[j];
                else gain += max-arr[j];
            }

            sb.append(gain).append("\n");
        }

        System.out.print(sb);
    }
}
