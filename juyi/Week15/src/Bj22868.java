import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj22868 {
	static int N, M, result, check[];
	static ArrayList<ArrayList<Integer>> list;
	static boolean visited[];
	static class Data{
		int v, c;

		public Data(int v, int c) {
			super();
			this.v = v;
			this.c = c;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// N 입력
		M = Integer.parseInt(st.nextToken());	// M 입력
		
		list = new ArrayList<ArrayList<Integer>>();	// 리스트 배열 생성
		
		for(int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<Integer>());	// 리스트 배열 내의 리스트 생성
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());	// a 입력
			int b = Integer.parseInt(st.nextToken());	// b 입력
			
			list.get(a).add(b);	// 인접 리스트에 저장
			list.get(b).add(a);	// 인접 리스트에 저장
		}
		
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());	// S 입력
		int E = Integer.parseInt(st.nextToken());	// E 입력
		
		for(int i = 1; i < N + 1; i++) Collections.sort(list.get(i));
		visited = new boolean[N + 1];
		check = new int[N + 1];
		
		bfs(S, E);
		
		for(int i = 0; i < N + 1; i++) {
			visited[i] = false;
		}
		
		int v = check[E];
		while(v > 0) {
			visited[v] = true;
			v = check[v];
		}
		
		visited[S] = false;
		
		bfs(E, S);
		
		System.out.println(result);
		
	}
	
	private static void bfs(int s, int e) {
		Queue<Data> queue = new ArrayDeque<>();
		
		queue.offer(new Data(s, 0));
		visited[s] = true;
		
		while(!queue.isEmpty()) {
			Data current = queue.poll();
			
			for(int v : list.get(current.v)) {
				if(visited[v]) continue;
				visited[v] = true;
				check[v] = current.v;
				queue.offer(new Data(v, current.c + 1));
				
				if(v == e) {
					result += current.c + 1;
					return;
				}
				
			}
		}
	}
}
