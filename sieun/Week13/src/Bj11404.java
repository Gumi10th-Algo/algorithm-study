import java.util.*;
import java.io.*;

public class Bj11404 {
	static int N, M;
	static int map[][];

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken()); // 도시의 개수

		st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken()); // 버스의 개수

		map = new int[N+1][N+1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			if(map[start][end] == 0)
				map[start][end] = cost;
			else
				map[start][end] = Math.min(map[start][end], cost);
		}
		
		setINF();
		
		floyd();
		
		setZero();

		printAns();
		System.out.println(sb);
	}

	//플로이드 워셜
	public static void floyd() {
		for(int k=1; k<=N; k++) { //경유지
			for(int a=1; a<= N; a++) { //출발지
				if(a == k) //출발지와 경유지가 같음
					continue;
				for(int b= 1; b<= N; b++) { //도착지
					if(a == b) //출발지와 도착지가 같음
						continue;
					if(b == k) //도착지와 경유지가 같음
						continue;
					map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
				}
			}
			//print();
		}
	}
	
	//무한대 설정
	public static void setINF() {
		for (int i = 1; i  <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i== j)
					continue;
				if(map[i][j] == 0) {
					map[i][j] = 1000000000;
				} 
			}
		}
	}
	
	//0으로 설정
		public static void setZero() {
			for (int i = 1; i  <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(i== j)
						continue;
					if(map[i][j] == 1000000000) {
						map[i][j] = 0;
					} 
				}
			}
		}
	
	//답 출력
	public static void printAns() {
		for (int i = 1; i  <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
	}
	
	
	//디버깅용
	public static void print() {
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
