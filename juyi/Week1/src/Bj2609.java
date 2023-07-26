import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader ����
		StringTokenizer st = new StringTokenizer(br.readLine()); // �������� �����Ͽ� �Է�
		int a = Integer.parseInt(st.nextToken()); // String�� int�� ��ȯ
		int b = Integer.parseInt(st.nextToken()); // String�� int�� ��ȯ
		
		// ��Ŭ���� ȣ���� ���
		// A = BQ + R1 -> B = R1Q + R2 -> R1 = R2Q + R3 ... ����������� ���� R�� �ִ�����
		int r, aa = 0, bb = 0;
		
		if(a % b == 0) r = b;
		else {
			r = a % b; // ù��° ������ ����
			aa = b;    // ���� �������� ���� ���ο� ������ ����
			bb = r;    // ���� ������ �� ���� ���ο� ������ ����
			
			while(true) {
				if(aa % bb == 0) break; // �������� 0�̸� r�� �������� �ʰ� Ż��
				r = aa % bb;            // �������� 0�� �ƴ� �� ���� ����
				aa = bb;                // �������� 0�� �ƴ� �� ���� ����
				bb = r;                 // �������� 0�� �ƴ� �� ���� ����
			}
		}
		
		System.out.println(r); // �������� 0�� �Ǳ� ���� r�� �ִ�����. ���
		System.out.println(a * b / r); // AB = L(�ּҰ����)G(�ִ�����) ���� �̿�
	}

}
