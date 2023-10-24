import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj3449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            String a = br.readLine();
            String b = br.readLine();

            int cnt = 0;
            for (int i = 0; i < a.length(); i++) {
                if(a.charAt(i) != b.charAt(i)) {
                    cnt ++;
                }
            }

            System.out.printf("Hamming distance is %d.\n", cnt);


        }

    }
}
