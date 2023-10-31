import java.util.*;
import java.io.*;

public class Bj4179 {
	
	static int R, C;
	static char map[][];
	static boolean visited[][];
	static int ans = Integer.MAX_VALUE;
	
	static class Jihoon{
		int x,y;
		int time;
		 
		public Jihoon(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
			
		}
	}
	
	static class Fire{
		int x,y;
		 
		public Fire(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	static Queue<Jihoon> q = new LinkedList<>();
	static Queue<Fire> fireQ = new LinkedList<>();
	

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char [R][C];
		visited = new boolean [R][C];
		
		//# : 벽 , . : 지나갈 수 있는 공간 , J : 지훈이의 미로에서 초기 위치, F : 불이난 위치
		for(int r =0; r<R; r++) {
			String str = bf.readLine();
			for(int c = 0; c<C; c++) {
				map[r][c] = str.charAt(c);
				if(map[r][c] == 'J') {
					q.add(new Jihoon(r,c,0));
					visited[r][c] = true;
				}
					
			}
		}
		
		bfs();
		
		System.out.println(ans == Integer.MAX_VALUE ? "IMPOSSIBLE" : ans);
	}
	
	public static void bfs() {
		
		while(!q.isEmpty()) {
			
			Jihoon curJihoon = q.poll();
			
			
			//가장 자리에 가면 답 계산하기 -> 최솟값 찾기   
			if(curJihoon.x == 0 || curJihoon.x == R-1 || curJihoon.y == 0 || curJihoon.y == C-1) {
				ans = Math.min(ans, curJihoon.time + 1);
			}
			
			//가장 자리 아님 -> 계속 진
			else {
				//지훈이 먼저 이동
				for(int i=  0; i<4; i++) {
					int nextX = curJihoon.x + dx[i];
					int nextY = curJihoon.y + dy[i];
					
					if(nextX < 0 || nextX >=R || nextY < 0 || nextY >= C)
						continue;
					if(map[nextX][nextY] == '#' || map[nextX][nextY] == 'F')
						continue;
					if(visited[nextX][nextY])
						continue;
					
					
					q.add(new Jihoon(nextX, nextY, curJihoon.time+1));
					visited[nextX][nextY] = true;
				}
				//불 이동 
				fire();
				
			}
			print();
		}
	}
	
	
	
	
	//불
	public static void fire() {
		//불 찾기
		for(int r=0; r<R; r++) {
			for(int c = 0; c<C; c++) {
				if(map[r][c] == 'F') {
					fireQ.add(new Fire(r,c));
				}
			}
		}
		
		//뷸 퍼트리기
		while(!fireQ.isEmpty()) {
			Fire curFire = fireQ.poll();
			
			for(int i =0; i<4; i++) {
				int nextX = curFire.x + dx[i];
				int nextY = curFire.y + dy[i];
				if(nextX < 0 || nextX >=R || nextY < 0 || nextY >= C)
					continue;
				if( map[nextX][nextY] == '#' )
					continue;
				else {
					map[nextX][nextY] = 'F';
				}
				
			}
		}		
	}
	
	//디버깅용
	public static void print() {
		System.out.println();
		for(int r=0; r<R; r++) {
			for(int c = 0; c<C; c++) {
				System.out.print(map[r][c]+ " ");
			}
			System.out.println();
		}
	}
}
