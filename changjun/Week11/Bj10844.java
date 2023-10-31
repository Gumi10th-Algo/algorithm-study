import java.io.*;
import java.util.*;

public class Bj10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long[] prev = {0,1,1,1,1,1,1,1,1,1};
        long[] dp = {0,1,1,1,1,1,1,1,1,1};

        for(int i=2;i<=N;i++){
            for(int j=0;j<10;j++){
                prev[j] = dp[j];
            }
            for(int j=0;j<10;j++){
                if(j==0) {
                    dp[0] = prev[1];
                } else if(j==9){
                    dp[9] = prev[8];
                } else
                    dp[j] = (prev[j-1] + prev[j+1])%1000000000;
            }
        }
        long cnt = 0;
        for(int i=0;i<10;i++){
            cnt+=dp[i];
        }
        System.out.println(cnt%1000000000);
    }
}
