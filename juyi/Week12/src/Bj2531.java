import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj2531 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] susi = new int[N];
		int[] selected = new int[d + 1];
		for(int i = 0; i < N; i++) {
			susi[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		for(int i = 0; i < k; i++) {
			if(++selected[susi[i]] == 1) cnt++;
		}
		if(++selected[c] == 1) cnt++;
		
		int max = cnt;
		
		int i = 0, j = i + k - 1;
		while(i < N) {
			if(--selected[susi[i++]] == 0) cnt--;
			if(++j >= N) j -= N;
			if(++selected[susi[j]] == 1) cnt++;
			if(++selected[c] == 1) cnt++;
			if(max < cnt) max = cnt;
		}
		
		System.out.println(max);
		
	}

}
