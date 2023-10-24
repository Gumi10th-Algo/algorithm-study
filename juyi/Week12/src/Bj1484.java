import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1484 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long G = Integer.parseInt(br.readLine());

		int cnt = 0;
		for(long i = 1; i < G; i++) {
			if(Math.sqrt(G + i * i) % 1 == 0) {
				cnt++;
				sb.append((int)Math.sqrt(G + i * i)).append("\n");
			}
		}

		if(cnt == 0) sb.append(-1);

		System.out.println(sb);
	}

}
