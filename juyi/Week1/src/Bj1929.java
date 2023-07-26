import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader ����
		StringTokenizer st = new StringTokenizer(br.readLine()); // ���� ����
		int M = Integer.parseInt(st.nextToken()); // M �Է�
		int N = Integer.parseInt(st.nextToken()); // N �Է�
		
		for(int i = M; i <= N; i++) {
			boolean prime = true;
			for(int j = 2; j <= Math.sqrt(i); j++) {
				if(i % j == 0) {
					prime = false; // ����������ٸ� �Ҽ��� �ƴϹǷ� false ó��
					break;
				}
			}
			if(i != 1 && prime == true) System.out.println(i); // 1�� �Ҽ��� �ƴϹǷ� 1 ����
		}
	}
}