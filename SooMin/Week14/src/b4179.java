import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class b4179 {

    static int N,M;
    static char[][] graph;

    static int cnt =1;
    static boolean flag = false;

    static int [] idx = new int[]{-1,0,1,0};
    static int [] idy = new int[]{0,1,0,-1};

    static ArrayDeque<Point> FMove = new ArrayDeque<>();
    static ArrayDeque<Point> JMove = new ArrayDeque<>();
    static ArrayDeque<Point> EOF = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();



    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = s.charAt(j);


                // 지훈이 위치 파악
                if(s.charAt(j)== 'J') {
                    JMove.add(new Point(i, j));
                }

                // 불꽃 위치 파악 - 여러개 일 수 있음
                if(s.charAt(j)=='F') {
                    FMove.add(new Point(i, j));
                }

                if((i == 0 || i == N-1 || j == 0 || j == M-1) && graph[i][j] != '#' && graph[i][j] != 'F') {
                    EOF.add(new Point(i,j));
                }

                if((i == 0 || i == N-1 || j == 0 || j == M-1) && graph[i][j] == 'J') {
                    System.out.println("1");
                    return;
                }

            }
        }

        if(EOF.isEmpty()){
            System.out.println("IMPOSSIBLE");
            return;
        }


        //bfs 돌리기
        while(true) {
            FMoving();
            JMoving();
            cnt++;

            if(flag){
                break;
            }

            if(JMove.isEmpty()){
                break;
            }

        }
        if(flag){
            System.out.println(sb);
        }else{
            sb.append("IMPOSSIBLE");
            System.out.println(sb);
        }


    }

    // 1. 불꽃 확산  -> 지훈이가 갈 수 있는 곳도 덮어버림
    public static void FMoving() {

        int Qszie = FMove.size();

        for (int i = 0; i < Qszie; i++) {
            Point Fire = FMove.poll();

            for (int j = 0; j < 4; j++) {
                int nx = Fire.x + idx[j];
                int ny = Fire.y + idy[j];

                if(nx>=0 && ny>=0 && nx< N && ny < M && graph[nx][ny] != '#' && graph[nx][ny] != 'F') {
                    graph[nx][ny] = 'F';
                    FMove.add(new Point(nx,ny));
                }
            }

        }

    }

    // 2. 지훈이 이동
    public static void JMoving() {

        int Qsize2 = JMove.size();

        for (int k = 0; k < Qsize2; k++) {
            Point Jihoon = JMove.poll();

            for (int i = 0; i < 4; i++) {
                int nx = Jihoon.x + idx[i];
                int ny = Jihoon.y + idy[i];

                if(nx>=0 && ny>= 0 && nx<N && ny<M && graph[nx][ny] == '.') {
                    graph[nx][ny] = 'J';
                    JMove.add(new Point(nx,ny));
                }

                if(nx<0 || ny<0 || nx>=N || ny>=M){
                    sb.append(cnt);
                    flag = true;
                    return;
                }
            }

        }
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
