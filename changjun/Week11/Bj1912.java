import java.io.*;
import java.util.*;

public class Bj1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            dp[i] = Integer.parseInt(st.nextToken());
        }

        int max = dp[0];
        for(int i=1;i<N;i++){
            if(dp[i-1]>0) dp[i] += dp[i-1];
            max = Math.max(max,dp[i]);
        }

        System.out.println(max);


    }
}
