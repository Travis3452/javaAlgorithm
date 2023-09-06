import java.util.Scanner;

public class javaBaekJoon16987 {
    static int N;
    static Egg [] arr;
    static int max = 0;
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new Egg [N];

        for(int i=0; i<N; i++) {
            int S = sc.nextInt();
            int W = sc.nextInt();
            arr[i] = new Egg(S, W);
        }

        DFS(0, 0, arr.clone());
        System.out.print(max);
    }

    public static void DFS(int index, int count, Egg [] eggs) {
        if(index == N || count == N) {
            max = Math.max(count, max);
            return;
        }

        if(eggs[index].isBreak()) {
            DFS(index+1, count, eggs.clone());
            return;
        }

        boolean check_eggs = true;

        for(int i=0; i<N; i++) {
            if(!eggs[i].isBreak() && i != index) check_eggs = false;
        }

        if(check_eggs) {
            max = Math.max(count, max);
            return;
        }

        for(int i=0; i<N; i++) {
            Egg [] temp = eggs.clone();
            if(!temp[i].isBreak() && i != index) {
                int tempCount = count;
                temp[i] = new Egg(temp[i].durability - temp[index].weight, temp[i].weight);
                if(temp[i].isBreak()) tempCount += 1;
                temp[index] = new Egg(temp[index].durability - temp[i].weight, temp[index].weight);
                if(temp[index].isBreak()) tempCount += 1;
                DFS(index+1, tempCount, temp.clone());
            }
        }
    }

    public static class Egg {
        int durability;
        int weight;
        Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
        public boolean isBreak() {
            return this.durability <= 0;
        }
    }
}