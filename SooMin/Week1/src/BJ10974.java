import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BJ10974 {
    static boolean visited[];
    static int arr[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        visited = new boolean[N];

        per(N, 0);

    }

    public static void per(int N, int deepth) {
        if(N == deepth) {
            for(int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i< N ; i++) {

            if(visited[i] == false) {
                visited[i] = true;
                arr[deepth] = i+1;
                per(N,deepth+1);
                visited[i] = false;
            }
        }

        return;

    }

}
