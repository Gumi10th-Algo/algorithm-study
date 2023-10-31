import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj14719 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[H][W];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < W; i++) {
			int block = Integer.parseInt(st.nextToken());
			int j = H - 1;
			while(block-- > 0) {
				map[j--][i] = -1;
			}
		}
		
		int rain = 0;
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(map[i][j] == 0) {
					int wall = 0;
					int left = j;
					int right = j;
					
					while(left >= 0 && map[i][left] == 0) {
						left--;
						if(left >= 0 && map[i][left] == -1) {
							wall++;
						}
					}
					
					while(right < W && map[i][right] == 0) {
						right++;
						if(right < W && map[i][right] == -1) {
							wall++;
						}
					}
					
					if(wall == 2) rain++;
				}
			}
		}
		
		System.out.println(rain);
	}

}
