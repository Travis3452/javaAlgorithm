import java.util.Arrays;
import java.util.Scanner;

public class javaBaekJoon1759 {
    static int L, C;
    static String [] chars;
    static boolean [] visited;
    static String [] arr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();

        chars = new String [C];
        visited = new boolean[C];

        arr = new String [L];

        for(int i=0; i<C; i++) {
            chars[i] = sc.next();
        }

        Arrays.sort(chars);

        DFS(0,0);

        System.out.print(sb);
    }

    public static void DFS(int at, int depth) {
        if(depth == L) {
            int countVowel = 0;
            int countConsonant = 0;

            for(int i=0; i<L; i++) {
                if(isVowel(arr[i])) {
                    countVowel++;
                }
                else {
                    countConsonant++;
                }
            }

            if(countVowel >= 1 && countConsonant >= 2) {
                for (int i = 0; i < L; i++) {
                    sb.append(arr[i]);
                }
                sb.append("\n");
            }
            return;
        }

        for(int i=at; i<C; i++) {
            if(!visited[i]) {
                arr[depth] = chars[i];
                visited[i] = true;
                DFS(i,depth+1);
                visited[i] = false;
            }
        }

    }

    public static boolean isVowel(String character) {
        boolean result = false;
        switch (character) {
            case "a":
                result = true;
                break;
            case "e":
                result = true;
                break;
            case "i":
                result = true;
                break;
            case "o":
                result = true;
                break;
            case "u":
                result = true;
                break;
        }
        return result;
    }
}
