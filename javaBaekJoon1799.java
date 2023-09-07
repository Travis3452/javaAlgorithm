import java.util.Scanner;

public class javaBaekJoon1799 {
    static int N;
    static boolean [][] canMove;
    static int [][] map;
    static int count = 0;
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[5][5];
        canMove = new boolean[5][5];

        for(int i=0; i<N*N; i++) {
            map[i/N][i%N] = sc.nextInt();
        }

        DFS(0, 0, 0);

    }

    public static void DFS(int x, int y, int count) {

    }

}
