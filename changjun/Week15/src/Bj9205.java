import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
// 맥주 마시면서 걸어가기
// 편의점을 bfs로 탐색.
public class Bj9205 {
    static class Sang{
        int x;
        int y;

        public Sang(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t=1;t<=T;t++){
            int N = Integer.parseInt(br.readLine());

            int[] home = new int[2];
            int[][] store = new int[N][2];
            int[] festival = new int[2];
            int[] isVisited = new int[N];

            st = new StringTokenizer(br.readLine());
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                store[i][0] = Integer.parseInt(st.nextToken());
                store[i][1] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            festival[0] = Integer.parseInt(st.nextToken());
            festival[1] = Integer.parseInt(st.nextToken());

            Queue<Sang> q = new ArrayDeque();
            q.add(new Sang(home[0],home[1]));

            int areYouHappy = 0;

            while(!q.isEmpty()){
                Sang s = q.poll();
                if(Math.abs(s.x-festival[0])+Math.abs(s.y-festival[1]) <= 1000){
                    areYouHappy = 1;
                    break;
                }

                for(int i=0;i<N;i++){
                    if(isVisited[i]==1) continue;
                    if(Math.abs(s.x-store[i][0])+Math.abs(s.y-store[i][1]) > 1000) continue;
                    q.add(new Sang(store[i][0],store[i][1]));
                    isVisited[i] = 1;
                }
            }

            if(areYouHappy == 1) System.out.println("happy");
            else System.out.println("sad");
        }
    }
}
