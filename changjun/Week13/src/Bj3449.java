import java.io.*;

public class Bj3449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            String s1 = br.readLine();
            String s2 = br.readLine();

            int cnt = 0;
            for(int i=0;i<s1.length();i++) {
                if(s1.charAt(i)!=s2.charAt(i)) cnt++;
            }
            System.out.printf("Hamming distance is %d.\n",cnt);
        }
    }


}