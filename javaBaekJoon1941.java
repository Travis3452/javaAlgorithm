import java.io.IOException;
import java.util.*;

public class javaBaekJoon1941 {
    static char [][] map = new char [5][5];
    static int [] arr = new int[7];
    static boolean [][] visited = new boolean[5][5];
    static int [] dx = {1, -1, 0, 0};
    static int [] dy = {0, 0, 1, -1};
    static int result = 0;
    public static void main(String [] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<5; i++) {
            String str = sc.nextLine();
            for(int j=0; j<5; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        DFS(0, 0, 0);
        System.out.println(result);
    }

    public static void DFS(int index, int count, int countS) {
        if(count == 7) {
            if(countS >= 4) result += BFS();
            return;
        }

        for(int i=index; i<25; i++) {
            int x = i % 5;
            int y = i / 5;

            if(!visited[y][x]) {
                arr[count] = 5*y+x;
                visited[y][x] = true;
                if(map[y][x] == 'S') DFS(i+1, count+1, countS+1);
                else DFS(i+1, count+1, countS);
                visited[y][x] = false;
            }
        }

    }
    public static int BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(arr[0]%5);
        q.offer(arr[0]/5);

        boolean [][] visit = new boolean[5][5];
        visit[arr[0]/5][arr[0]%5] = true;

        int count = 1;

        while(!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();

            for(int i=0; i<4; i++) {
                int nextX = x+dx[i];
                int nextY = y+dy[i];

                if(checkPosition(nextX, nextY) && visited[nextY][nextX] && !visit[nextY][nextX]) {
                    count++;
                    visit[nextY][nextX] = true;
                    q.add(nextX);
                    q.add(nextY);
                }
            }
        }
        if (count == 7) return 1;
        else return 0;
    }
    public static boolean checkPosition(int x, int y) {
        boolean checkX = (x >= 0 && x < 5);
        boolean checkY = (y >= 0 && y < 5);

        return checkX && checkY;
    }
}
