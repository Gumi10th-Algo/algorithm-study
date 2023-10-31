import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj13701 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] check = new int[(1 << 20)];
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			
			int idx = num / 32;
			int shift = num  % 32;
			
			if((check[idx] & (1 << shift)) != 0) continue;
			
			sb.append(num).append(" ");
			check[idx] |= (1 << shift);
		}
		
		System.out.println(sb);
	}

}
