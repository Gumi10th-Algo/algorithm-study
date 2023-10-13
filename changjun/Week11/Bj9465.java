import java.io.*;
import java.util.*;
// 스티커
// 1을 선택 or 2을 선택 or 난 선택하지 않는다!
public class Bj9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t=1;t<=T;t++){
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][2];
            int[][] Score = new int[N][3];

            for(int i=0;i<2;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    map[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            Score[0][0] = map[0][0];
            Score[0][1] = map[0][1];

            // 1을 뗀다, 2를 뗸다, 떼지 않는다.

            for(int i=1;i<N;i++){
                // N번 째 줄에서 0번을 선택할 경우
                if(Score[i-1][1]+map[i][0] > Score[i][0]) Score[i][0] = Score[i-1][1]+map[i][0];
                if(Score[i-1][2]+map[i][0] > Score[i][0]) Score[i][0] = Score[i-1][2]+map[i][0];

                // N번 째 줄에서 1번을 선택할 경우
                if(Score[i-1][0]+map[i][1] > Score[i][1]) Score[i][1] = Score[i-1][0]+map[i][1];
                if(Score[i-1][2]+map[i][1] > Score[i][1]) Score[i][1] = Score[i-1][2]+map[i][1];

                // N번 째 줄에서 선택하지 않을 경우.
                Score[i][2] = Math.max(Score[i-1][0],Score[i-1][1]);
            }

            int max = 0;
            for(int i=0;i<3;i++){
                if(Score[N-1][i] > max) max = Score[N-1][i];
            }
            System.out.println(max);
        }

    }
}
