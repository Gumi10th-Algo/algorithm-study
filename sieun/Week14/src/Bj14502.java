import java.util.*;
import java.io.*;

public class Bj14502 {
	
	static int N, M;
	static int map[][], temp[][];
	static int max = Integer.MIN_VALUE;
	
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken()); //세로 크기  
		M = Integer.parseInt(st.nextToken()); //가로 크기   
		
		map = new int [N][M];
		temp = new int [N][M];
		
		
		//0 : 빈칸,  1:  벽 , 2 : 바이러스  
		for(int i =0;i < N ; i++) {
			 st = new StringTokenizer(bf.readLine());
			 for(int j=0; j<M; j++) {
				 map[i][j] = Integer.parseInt(st.nextToken());
			 }
		}
		
		makeWall(0);
		
		System.out.println(max);
		
		
	}
	
	//벽 3개 만들기  
	public static void makeWall(int cnt) {
		
		//벽 3개 만들면 바이러스 확산 + 안전지역 count   
		if(cnt == 3) {
			copyMap();
			Virus();
			max = Math.max(max, countSafe());
			initMap();
			return;
		}
		
		//벽 3개 만들기  :  backtracking 
		for(int i =0 ; i<N; i++) {
			for(int j =0; j<M; j++) {
				if(map[i][j] == 2 || map[i][j] ==1 )
					continue;
				else {
					map[i][j] = 1;
					makeWall(cnt + 1);
					map[i][j] = 0;
				}
					
					
			}
		}
	}
	
	//바이러스 퍼지기 : bfs
	public static void Virus() {
		Queue <Node> q = new LinkedList<>();
		
		//초기 바이러스 위치 추가  
		for(int i = 0; i<N; i++) {
			for(int j =0; j< M ; j++) {
				if(map[i][j] == 2)
					q.add(new Node(i, j));
			}
		}
		
		//바이러스 퍼트리기 : bfs 
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			for(int i =0; i<4; i++) {
				int nextX = curNode.x + dx[i];
				int nextY = curNode.y + dy[i];
				if(nextX < 0 || nextX >= N || nextY< 0 || nextY >= M)
					continue;
				if(map[nextX][nextY] == 0) {
					map[nextX][nextY] = 2;
					q.add(new Node(nextX, nextY));
				}
			}
		}
	}
	
	
	//map 복사해두기 
		public static void copyMap() {
			for(int i=0; i<N; i++)
				temp[i] = map[i].clone();
		}
	
	//map 초기화 하기   
	public static void initMap() {
		for(int i=0; i<N; i++)
			map[i] = temp[i].clone();
	}
	
	
	//안전 지역 count 하기  
	public static int countSafe() {
		int count = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] == 0)
					count++;	
			}
		}
		return count ;
	}
	
	
}
