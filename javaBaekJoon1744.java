import java.util.Arrays;
import java.util.Scanner;

public class javaBaekJoon1744 {
    static int N;
    static int [] arr;
    static int negativeCount = 0;
    static int oneCount = 0;
    static int positiveCount = 0;

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int [N];

        for(int i=0; i<N; i++) arr[i] = sc.nextInt();

        Arrays.sort(arr);
        // 양수     큰 순서대로 2개씩 묶어서 곱하기 and 남는건 더하기
        // 1       전부 더하기
        // 0       남는 음수에 곱해서 없애기
        // 음수     작은 순서대로 2개씩 묶어서 곱하기

        for(int i=0; i<N; i++) {
            if(arr[i] <= 0) negativeCount++;
            else if(arr[i] == 1) oneCount++;
            else positiveCount++;
        }

        int sum = 0;

        if(negativeCount % 2 == 0) {
            for (int i=0; i<negativeCount; i+=2) {
                sum += arr[i] * arr[i+1];
            }
        }
        else {
            for(int i=0; i<negativeCount-1; i+=2) {
                sum += arr[i]*arr[i+1];
            }
            sum += arr[negativeCount-1];
        }

        int oneIndex = negativeCount;

        for(int i=oneIndex; i<oneIndex+oneCount; i++) {
            sum += 1;
        }

        int positiveIndex = oneIndex + oneCount;

        if(positiveCount % 2 == 0) {
            for(int i = positiveIndex+positiveCount-1; i > positiveIndex; i -= 2) {
                sum += arr[i] * arr[i-1];
            }
        }
        else {
            for(int i = positiveIndex+positiveCount-1; i > positiveIndex+1; i -= 2) {
                sum += arr[i] * arr[i-1];
            }
            sum += arr[positiveIndex];
        }

        System.out.println(sum);
    }
}
