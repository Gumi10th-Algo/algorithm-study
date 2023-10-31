import java.io.*;
import java.util.*;
// 데스스타

// 비트 | 연산
public class Bj11811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        int[] arr = new int[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i==j) continue;
                arr[i] = arr[i] | map[i][j];
            }
        }

        for(int i=0;i<N;i++){
            System.out.print(arr[i]+" ");
        }

    }
}
