import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj3449 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			sb.append("Hamming distance is ");
			String a = br.readLine();
			String b = br.readLine();
			
			int distance = 0;
			for(int i = 0; i < a.length(); i++) {
				if(a.charAt(i) != b.charAt(i)) distance++;
			}
			
			sb.append(distance).append(".\n");
		}
		
		System.out.print(sb);
	}

}
