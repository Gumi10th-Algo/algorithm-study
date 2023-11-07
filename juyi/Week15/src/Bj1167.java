import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bj1167 {

	static int V, max, maxIdx;
	static List<int[]>[] list;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		V = Integer.parseInt(br.readLine());

		list = new List[V + 1];
		
		for(int i = 0; i < V + 1; i++) {
			list[i] = new ArrayList<>();
		}

		loop : for(int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int idx = Integer.parseInt(st.nextToken());
			while(true) {
				int temp = Integer.parseInt(st.nextToken());

				if(temp == -1) continue loop;

				int s = Integer.parseInt(st.nextToken());
				list[idx].add(new int[] {temp, s});
			}
		}
		
		visited = new boolean[V + 1];
		max = Integer.MIN_VALUE;
		
		dfs(1, 0);
		
		visited = new boolean[V + 1];
		dfs(maxIdx, 0);
		System.out.println(max);
	}
	
	private static void dfs(int current, int sum) {
		visited[current] = true;
		
		for(int i = 0; i < list[current].size(); i++) {
			int idx = list[current].get(i)[0];
			int s = list[current].get(i)[1];
			
			if(visited[idx]) continue;
			
			visited[idx] = true;
			dfs(idx, sum + s);
			visited[idx] = false;
		}
		
		if(max < sum) {
			max = sum;
			maxIdx = current;
		}
	}

}
