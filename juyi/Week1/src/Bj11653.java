import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj11653 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader ����
		int N = Integer.parseInt(br.readLine()); // N �Է� �ޱ�
		
		int i = 2; // ���μ����� 2���� ����
		while(true) { // N�� 1�� �� ������ �ݺ�
			if(N == 1) return; // N�� 1�̸� main ����
			if(N % i == 0) { // N�� i�� ������ �������� ���μ����� 
				System.out.println(i); // i ���
				N /= i; // N�� i�� ���� ������ ��ȯ
				i = 2;  // �ٽ� 2���� ���μ����� ����
			}
			else i++; // N�� i�� ������ �������� ������ i ����
		}
	}
}
