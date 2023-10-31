import java.util.*;
import java.io.*;

public class Bj10971 {
    static int[][] graph;
    static boolean[] visited;
    static int N;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++) {
            visited[i] = true;
            dfs(i, 0, i);
            visited[i] = false;
        }
        System.out.println(answer);
    }

    static void dfs(int node, int result, int startNode){
        if(result > answer){
            return;
        }
        if(checkVisited()){
            if(graph[node][startNode] != 0) {
                answer = Math.min(answer, result + graph[node][startNode]);
            }
        }
        for(int i=0; i<N; i++){
            if(!visited[i] && graph[node][i] != 0){
                visited[i] = true;
                dfs(i, result + graph[node][i], startNode);
                visited[i] = false;
            }
        }
    }

    static boolean checkVisited(){
        for(int i=0; i<N; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
}