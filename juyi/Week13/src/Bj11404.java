import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 23-10-24
 * Bj11404 : 플로이드
 * 
 * 플로이드워샬 알고리즘 이용 문제
 * 정점 a에서 b까지 다른 정점들을 경유하면서 가는 최단 경로
 */
public class Bj11404 {

	static final int INF = 100_000_000;	// 오버플로우 방지를 위해 Integer.MAX_VALUE가 아닌 적당히 큰 값으로 저장
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());	// 도시의 개수
		int m = Integer.parseInt(br.readLine());	// 버스의 개수
		
		int[][] adj = new int[n + 1][n + 1];	// 인접 행렬 생성
		
		for(int i = 0; i < n + 1; i++) {
			for(int j = 0; j < n + 1; j++) {
				if(i==j) {	// 출발지와 도착지가 같으면
					adj[i][j] = 0;	// 비용은 0
					continue;
				}
				adj[i][j] = INF;	// 적당히 큰 값으로 초기화
			}
		}
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());	// 출발지
			int b = Integer.parseInt(st.nextToken());	// 도착지
			int c = Integer.parseInt(st.nextToken());	// 비용
			
			if(adj[a][b] > c) adj[a][b] = c;	// 현재 값보다 작으면 저장
		}
		
		for(int k = 1; k < n + 1; k++) {	// k를 경유하면서
			for(int i = 1; i < n + 1; i++) {	// i에서
				if(k == i) continue;	// 경유지와 출발지가 같으면 continue
				for(int j = 1; j < n + 1; j++) {	// j까지의 최단 경로
					if(i == j) continue;	// 출발지와 도착지가 같으면 continue
					if(k == j) continue;	// 경유지와 도착지가 같으면 continue
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]); 	// 출발지->도착지 경우와 출발지->경유지 + 경유지->출발지 경우 중 최소값 저장
				}
			}
		}
		
		// 결과 출력
		for(int i = 1; i < n + 1; i++) {
			for(int j = 1; j < n + 1; j++) {
				if(i==j || adj[i][j] == INF) {	
					sb.append(0).append(" ");
					continue;
				}
				
				sb.append(adj[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}

}
