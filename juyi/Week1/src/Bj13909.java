import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj13909 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader ����
		int N = Integer.parseInt(br.readLine()); // N �Է� �ޱ�
		
		int count = 0, i = 1;
		
		while(i * i <= N) { // �������� ������ ã�� ���� �ݺ���
			count++;
			i++;
		}
		
		System.out.println(count);
		
	}
}
