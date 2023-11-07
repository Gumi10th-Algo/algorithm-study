import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj9205 {

	static int n, adj[][];
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for(int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			int[][] xy = new int[n + 2][2];

			for(int i = 0; i < n + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				xy[i][0] = x;
				xy[i][1] = y;
			}

			adj = new int[n + 2][n + 2];
			for(int i = 0; i < n + 2; i++) {
				for(int j = 0; j < n + 2; j++) {
					if(i == j) continue;

					if(adj[i][j] != 0) continue;

					if(Math.abs(xy[i][0] - xy[j][0]) + Math.abs(xy[i][1] - xy[j][1]) <= 1000) {
						adj[i][j] = adj[j][i] = 1;
					}
				}
			}

			visited = new boolean[n + 2];
			visited[0] = true;

			dfs(0);
			
			sb.append(visited[n + 1]? "happy":"sad").append("\n");
		}

		System.out.println(sb);
	}

	private static void dfs(int current) {
		for(int j = 0; j < n + 2; j++) {
			if(adj[current][j] == 1) {
				if(!visited[j]) {
					visited[j] = true;
					dfs(j);
				}
			}
		}
	}

}
