import java.io.IOException;
import java.util.Scanner;

public class javaBaekJoon1439 {
    static int [] arr;
    static int oneToZero = 0;
    static int zeroToOne = 0;

    public static void main(String [] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        arr = new int [str.length()];

        for(int i=0; i<str.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        int before = arr[0];

        for(int i=1;i<arr.length; i++) {
            if(arr[i] != before) {
                if(arr[i] == 0) oneToZero++;
                else            zeroToOne++;
                before = arr[i];
            }
        }
        System.out.println(Math.max(oneToZero, zeroToOne));
    }
}
