import java.util.Arrays;
import java.util.Scanner;

public class javaBaekJoon2457 {
    static Flower [] arr;
    static int N;
    static int count = 0;

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new Flower [N];

        for (int i=0; i<N; i++) {
            int startMonth = sc.nextInt();
            int startDay = sc.nextInt();
            int endMonth = sc.nextInt();
            int endDay = sc.nextInt();

            arr[i] = new Flower(startMonth, startDay, endMonth, endDay);
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.start == o2.start) return o1.end - o2.end;
            else return o1.start - o2.start;
        });

        int max = 0;
        int cur = 301;
        int index = 0;

        while(cur < 1201) {
            boolean check = false;

            for(int i=index; i<N; i++) {
                if (arr[i].start > cur) break;
                if (arr[i].end > max) {
                    max = arr[i].end;
                    index++;
                    check = true;
                }
            }
            if(check) {
                cur = max;
                count++;
            } else break;
        }
        if(cur < 1201) System.out.println(0);
        else System.out.println(count);
    }
    public static class Flower {
        int start;
        int end;

        Flower(int startMonth, int startDay, int endMonth, int endDay) {
            this.start = startMonth*100 + startDay;
            this.end = endMonth*100 + endDay;
        }
    }
}
