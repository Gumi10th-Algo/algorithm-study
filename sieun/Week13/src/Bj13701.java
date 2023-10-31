import java.util.*;
import java.io.*;
public class Bj13701 {
	
	static BitSet bitset = new BitSet(33554432);
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int len = st.countTokens();
		
		for(int i=0; i<len; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(bitset.get(n)) {
				continue;
			}
			else {
				bitset.set(n);
				sb.append(n).append(" ");
			}
		}
		
		
		System.out.println(sb);
	}
}
